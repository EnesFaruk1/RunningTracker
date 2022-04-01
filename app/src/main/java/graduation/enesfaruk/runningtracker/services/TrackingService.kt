package graduation.enesfaruk.runningtracker.services

import android.content.Intent
import androidx.lifecycle.LifecycleService
import graduation.enesfaruk.runningtracker.other.Constants.ACTION_PAUSE_SERVICE
import graduation.enesfaruk.runningtracker.other.Constants.ACTION_START_OR_RESUME_SERVICE
import graduation.enesfaruk.runningtracker.other.Constants.ACTION_STOP_SERVICE
import timber.log.Timber

/**
 * Created by Enes Faruk Işık on 1.04.2022.
 */
class TrackingService : LifecycleService() {

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        intent?.let {
            when(it.action){
                ACTION_START_OR_RESUME_SERVICE -> {
                    Timber.d("Started or resumed service")
                }
                ACTION_PAUSE_SERVICE -> {
                    Timber.d("Paused service")
                }
                ACTION_STOP_SERVICE -> {
                    Timber.d("Stopped service")
                }
            }
        }
        return super.onStartCommand(intent, flags, startId)
    }
}