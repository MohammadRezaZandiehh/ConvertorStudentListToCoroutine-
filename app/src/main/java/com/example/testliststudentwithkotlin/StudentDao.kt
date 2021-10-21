package com.example.testliststudentwithkotlin

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StudentDao {

    @Query("SELECT * FROM students")                                                           // get student's Lists from Database If there is something in it
    fun getStudents(): LiveData<List<Student>>

    @Insert                                                                                         //when get student's Lists from server, we add them too Database :
    suspend fun addStudent(student: List<Student>)
}