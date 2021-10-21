package com.example.testliststudentwithkotlin

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LiveData
import javax.inject.Inject

class Repository @Inject constructor(
    private val studentDao: StudentDao,
    private val apiService: ApiService
) {

                                                                                                    // get studentList from server and add to Database
    suspend fun refreshStudent() {
        val students : List<Student> = apiService.getStudent()
        studentDao.addStudent(students)
    }


                                                                                                    // firstly we get cash studentList from Database (if user see them and now for example don't have net)
    fun getStudents(): LiveData<List<Student>> {
        return studentDao.getStudents()
    }
}