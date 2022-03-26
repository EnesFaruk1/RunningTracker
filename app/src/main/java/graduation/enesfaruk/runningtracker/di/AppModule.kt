package graduation.enesfaruk.runningtracker.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import graduation.enesfaruk.runningtracker.db.RunningDatabase
import graduation.enesfaruk.runningtracker.other.Constants.RUNNING_DATABASE_NAME
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
}