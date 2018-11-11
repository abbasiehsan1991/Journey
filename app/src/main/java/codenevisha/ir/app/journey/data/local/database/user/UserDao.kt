package codenevisha.ir.app.journey.data.local.database.user

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface UserDao {

    /**
     * Select all userEntities from the userEntities (We have only on user ) table.
     *
     * @return all userEntities.
     */
    @get:Query("SELECT * FROM userEntities")
    val userEntities: List<UserEntity>

    /**
     * Insert userEntity info into database
     */
    @Insert
    fun addUser(userEntity: UserEntity)

}
