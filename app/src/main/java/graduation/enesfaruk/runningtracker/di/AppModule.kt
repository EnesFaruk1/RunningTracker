package graduation.enesfaruk.runningtracker.di

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import graduation.enesfaruk.runningtracker.db.RunningDatabase
import graduation.enesfaruk.runningtracker.other.Constants.KEY_FIRST_TIME_TOGGLE
import graduation.enesfaruk.runningtracker.other.Constants.KEY_NAME
import graduation.enesfaruk.runningtracker.other.Constants.KEY_WEIGHT
import graduation.enesfaruk.runningtracker.other.Constants.RUNNING_DATABASE_NAME
import graduation.enesfaruk.runningtracker.other.Constants.SHARED_PREFERENCES_NAME
import javax.inject.Singleton

/**
 * Created by Enes Faruk Işık on 26.03.2022.
 */

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRunningDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        RunningDatabase::class.java,
        RUNNING_DATABASE_NAME
    ).build()

    @Singleton
    @Provides
    fun provideRunDAO(db: RunningDatabase) = db.getRunDao()

    @Singleton
    @Provides
    fun provideSharedPreferences(@ApplicationContext app: Context) =
        app.getSharedPreferences(SHARED_PREFERENCES_NAME, MODE_PRIVATE)

    @Singleton
    @Provides
    fun provideName(sharedPref: SharedPreferences) = sharedPref.getString(KEY_NAME, "") ?: ""

    @Singleton
    @Provides
    fun provideWeight(sharedPref: SharedPreferences) = sharedPref.getFloat(KEY_WEIGHT, 80f)

    @Singleton
    @Provides
    fun provideFirstTimeToggle(sharedPref: SharedPreferences) =
        sharedPref.getBoolean(KEY_FIRST_TIME_TOGGLE, true)

}