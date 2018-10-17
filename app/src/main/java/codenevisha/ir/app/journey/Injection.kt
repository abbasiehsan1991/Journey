package codenevisha.ir.app.journey

import android.content.Context

import codenevisha.ir.app.journey.data.AppDataSource
import codenevisha.ir.app.journey.data.AppRepository
import codenevisha.ir.app.journey.data.local.HomeLocalDataSource
import codenevisha.ir.app.journey.data.local.database.AppDatabase
import codenevisha.ir.app.journey.data.remote.HomeRemoteDataSource
import codenevisha.ir.app.journey.util.AppExecutors


/**
 * Enables injection for
 * [AppDataSource] at compile time.
 */

object Injection {

    fun provideApplicationRepository(context: Context): AppRepository {

        val database = AppDatabase.getInstance(context)

        return AppRepository.getInstance(
                HomeRemoteDataSource.instance,
                HomeLocalDataSource.getInstance(AppExecutors(), database.userDao())
        )

    }
}
