package graduation.enesfaruk.runningtracker.ui.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import graduation.enesfaruk.runningtracker.repositories.MainRepository
import javax.inject.Inject

/**
 * Created by Enes Faruk Işık on 26.03.2022.
 */

@HiltViewModel
class MainViewModel @Inject constructor(
    val mainRepository: MainRepository
): ViewModel() {
}