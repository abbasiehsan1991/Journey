package codenevisha.ir.app.journey.data.local.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

import codenevisha.ir.app.journey.data.local.database.user.UserEntity
import codenevisha.ir.app.journey.data.local.database.user.UserDao

@Database(entities = arrayOf(UserEntity::class), version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {


        private var INSTANCE: AppDatabase? = null

        private val sLock = Any()

        fun getInstance(context: Context): AppDatabase {
            synchronized(sLock) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                            AppDatabase::class.java, "journey.db")
                            .build()
                }
                return INSTANCE!!
            }
        }
    }

}
