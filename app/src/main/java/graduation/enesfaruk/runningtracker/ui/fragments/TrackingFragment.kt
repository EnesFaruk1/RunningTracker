package graduation.enesfaruk.runningtracker.ui.fragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import graduation.enesfaruk.runningtracker.R
import graduation.enesfaruk.runningtracker.ui.viewmodels.MainViewModel

/**
 * Created by Enes Faruk Işık on 26.03.2022.
 */

@AndroidEntryPoint
class TrackingFragment : Fragment(R.layout.fragment_tracking) {

    private val viewModel: MainViewModel by viewModels()

}