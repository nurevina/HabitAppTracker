package com.dicoding.habitapp.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun register(user: User)

    @Query("SELECT * FROM user WHERE username = :username & password = :password")
    fun login(username : String, password : String) : User

}