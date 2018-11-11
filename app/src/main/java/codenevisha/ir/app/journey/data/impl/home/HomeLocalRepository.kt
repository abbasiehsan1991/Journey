package codenevisha.ir.app.journey.data.impl.home

import codenevisha.ir.app.journey.data.repository.HomeRepository
import codenevisha.ir.app.journey.data.local.database.user.UserDao
import codenevisha.ir.app.journey.util.executer.AppExecutors


class HomeLocalRepository private constructor(appExecutors: AppExecutors, userDao: UserDao) : HomeRepository.HomeInterface {

    override fun getArticlesNormal(callback: HomeRepository.LoadDataCallback, force: Boolean) {
        getArticlesRx(callback, force)
    }

    override fun getArticlesRx(callback: HomeRepository.LoadDataCallback, force: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    private val TAG = "HomeLocalRepository"

    private lateinit var mUserDao: UserDao

    private lateinit var mAppExecutors: AppExecutors

    companion object {

        private var INSTANCE: HomeLocalRepository? = null

        fun getInstance(appExecutors: AppExecutors,
                        tasksDao: UserDao): HomeLocalRepository {

            if (INSTANCE == null) {

                synchronized(HomeLocalRepository::class.java) {

                    if (INSTANCE == null) {
                        INSTANCE = HomeLocalRepository(appExecutors, tasksDao)
                    }

                }
            }
            return INSTANCE!!
        }
    }
}