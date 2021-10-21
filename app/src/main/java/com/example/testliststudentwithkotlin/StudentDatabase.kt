package com.example.testliststudentwithkotlin

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [Student::class], exportSchema = false, version = 1)
abstract class StudentDatabase : RoomDatabase() {

    abstract fun studentDao(): StudentDao
}
