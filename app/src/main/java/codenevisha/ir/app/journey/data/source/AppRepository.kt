package project.data.source

class AppRepository// Prevent direct instantiation.
private constructor(private val mAppRemoteDataSource: AppDataSource,
                    private val mAppLocalDataSource: AppDataSource) : AppDataSource {

    companion object {

        private var INSTANCE: AppRepository? = null


        /**
         * Returns the single instance of this class, creating it if necessary.
         *
         * @param appRemoteDataSource the backend data source
         * @param appLocalDataSource  the device storage data source
         * @return the [AppRepository] instance
         */
        fun getInstance(appRemoteDataSource: AppDataSource, appLocalDataSource: AppDataSource): AppRepository {

            if (INSTANCE == null)
                INSTANCE = AppRepository(appRemoteDataSource, appLocalDataSource)

            return INSTANCE!!
        }


        /**
         *Clear Available Instance
         */
        fun destroyInstance() {
            INSTANCE = null
        }
    }

}

