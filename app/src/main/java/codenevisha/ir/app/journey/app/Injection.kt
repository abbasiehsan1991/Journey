package codenevisha.ir.app.journey.app

import android.content.Context

import codenevisha.ir.app.journey.data.repository.HomeRepository
import codenevisha.ir.app.journey.data.impl.home.HomeRepositoryImpl
import codenevisha.ir.app.journey.data.impl.home.HomeLocalRepository
import codenevisha.ir.app.journey.data.local.database.AppDatabase
import codenevisha.ir.app.journey.data.impl.home.HomeRemoteRepository
import codenevisha.ir.app.journey.util.executer.AppExecutors


/**
 * Enables injection for
 * [HomeRepository] at compile time.
 */

object Injection {

    fun provideApplicationRepository(context: Context): HomeRepositoryImpl {

        val database = AppDatabase.getInstance(context)

        return HomeRepositoryImpl.getInstance(
                HomeRemoteRepository.instance,
                HomeLocalRepository.getInstance(AppExecutors(), database.userDao())
        )

    }
}
