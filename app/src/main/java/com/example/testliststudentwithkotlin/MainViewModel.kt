package com.example.testliststudentwithkotlin

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


class MainViewModel @ViewModelInject constructor(
    private val apiService: ApiService
) : ViewModel() {
    val studentLiveData = MutableLiveData<List<Student>>()
    private val errorLiveData = MutableLiveData<String>()

    init {
        viewModelScope.launch {
            val students = apiService.getStudent()
            studentLiveData.value = students
        }
    }
//    fun getApi() {
//        viewModelScope.launch {
//            apiService.getStudent()
//        }
//    }
}