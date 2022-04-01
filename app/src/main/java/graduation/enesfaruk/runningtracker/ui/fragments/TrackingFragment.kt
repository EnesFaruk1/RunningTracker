package graduation.enesfaruk.runningtracker.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.android.gms.maps.GoogleMap
import dagger.hilt.android.AndroidEntryPoint
import graduation.enesfaruk.runningtracker.R
import graduation.enesfaruk.runningtracker.other.Constants.ACTION_START_OR_RESUME_SERVICE
import graduation.enesfaruk.runningtracker.services.TrackingService
import graduation.enesfaruk.runningtracker.ui.viewmodels.MainViewModel
import kotlinx.android.synthetic.main.fragment_tracking.*

/**
 * Created by Enes Faruk Işık on 26.03.2022.
 */

@AndroidEntryPoint
class TrackingFragment : Fragment(R.layout.fragment_tracking) {

    private val viewModel: MainViewModel by viewModels()

    private var map: GoogleMap? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnToggleRun.setOnClickListener {
            sendCommandToService(ACTION_START_OR_RESUME_SERVICE)
        }
        mapView.onCreate(savedInstanceState)

        mapView.getMapAsync{
            map = it
        }
    }

    private fun sendCommandToService(action: String){
        Intent(requireContext(), TrackingService::class.java).also {
            it.action = action
            requireContext().startService(it)
        }
    }

    override fun onResume() {
        super.onResume()
        mapView?.onResume()
    }

    override fun onStart() {
        super.onStart()
        mapView?.onStart()
    }

    override fun onStop() {
        super.onStop()
        mapView?.onStop()
    }

    override fun onPause() {
        super.onPause()
        mapView?.onPause()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView?.onLowMemory()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mapView?.onSaveInstanceState(outState)
    }
}