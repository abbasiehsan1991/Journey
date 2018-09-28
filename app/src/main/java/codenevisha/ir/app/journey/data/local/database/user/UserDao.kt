package codenevisha.ir.app.journey.data.local.database.user

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface UserDao {

    /**
     * Select all users from the users (We have only on user ) table.
     *
     * @return all users.
     */
    @get:Query("SELECT * FROM users")
    val users: List<User>

    /**
     * Insert user info into database
     */
    @Insert
    fun addUser(user: User)

}
