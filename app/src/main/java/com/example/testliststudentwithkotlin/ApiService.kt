package com.example.testliststudentwithkotlin

import retrofit2.http.GET

interface ApiService {

    @GET("experts/student")
    suspend fun getStudent() : List<Student>
}