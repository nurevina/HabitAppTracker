package com.dicoding.habitapp.data

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "user")
data class User(
    @NonNull
    @ColumnInfo(name = "username")
    val id: String ,

    @NonNull
    @ColumnInfo(name = "full_name")
    val fullName: String,

    @NonNull
    @ColumnInfo(name = "password")
    val password: String
): Parcelable
