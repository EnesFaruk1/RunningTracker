package graduation.enesfaruk.runningtracker.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import graduation.enesfaruk.runningtracker.R
import kotlinx.android.synthetic.main.fragment_setup.*

/**
 * Created by Enes Faruk Işık on 26.03.2022.
 */
class SetupFragment : Fragment(R.layout.fragment_setup) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvContinue.setOnClickListener{
            findNavController().navigate(R.id.action_setupFragment_to_runFragment)

        }
    }
}