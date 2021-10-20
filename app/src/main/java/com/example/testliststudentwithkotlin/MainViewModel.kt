package com.example.testliststudentwithkotlin

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch


class MainViewModel @ViewModelInject constructor(
    private val apiService: ApiService
) : ViewModel() {

    val coroutineExceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        errorLiveData.value = throwable.message
    }
    val errorLiveData = MutableLiveData<String>()


    val studentLivedata: LiveData<List<Student>> = liveData(coroutineExceptionHandler) {
        val students = apiService.getStudent()
        emit(students)                                                                              // send students to MainActivity's observers.
    }

//    init {
//        viewModelScope.launch {
//            val students = apiService.getStudent()
//            studentLiveData.value = students
//        }
//    }

}