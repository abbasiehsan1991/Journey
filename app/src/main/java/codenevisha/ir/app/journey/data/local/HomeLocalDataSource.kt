package codenevisha.ir.app.journey.data.local

import codenevisha.ir.app.journey.data.AppDataSource
import codenevisha.ir.app.journey.data.local.database.user.UserDao
import codenevisha.ir.app.journey.util.AppExecutors


class HomeLocalDataSource private constructor(appExecutors: AppExecutors, userDao: UserDao) : AppDataSource.HomeInterface {

    override fun getArticles(callback: AppDataSource.LoadDataCallback, force: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    private val TAG = "HomeLocalDataSource"

    private lateinit var mUserDao: UserDao

    private lateinit var mAppExecutors: AppExecutors

    companion object {

        private var INSTANCE: HomeLocalDataSource? = null

        fun getInstance(appExecutors: AppExecutors,
                        tasksDao: UserDao): HomeLocalDataSource {

            if (INSTANCE == null) {

                synchronized(HomeLocalDataSource::class.java) {

                    if (INSTANCE == null) {
                        INSTANCE = HomeLocalDataSource(appExecutors, tasksDao)
                    }

                }
            }
            return INSTANCE!!
        }
    }
}