package codenevisha.ir.app.journey.util.executer

import android.support.annotation.VisibleForTesting

import java.util.concurrent.Executor
import java.util.concurrent.Executors

/**
 * Global executor pools for the whole application.
 * Used for database and other stuffs in application
 */
class AppExecutors @VisibleForTesting
internal constructor(private val diskIO: Executor, private val networkIO: Executor, private val mainThread: Executor) {

    constructor() : this(
            DiskIOThreadExecutor(),
            Executors.newFixedThreadPool(THREAD_COUNT),
            MainThreadExecutor()) {
    }

    fun diskIO(): Executor {
        return diskIO
    }

    fun networkIO(): Executor {
        return networkIO
    }

    fun mainThread(): Executor {
        return mainThread
    }

    companion object {

        private val THREAD_COUNT = 3
    }


}
