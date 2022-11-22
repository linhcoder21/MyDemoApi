package com.example.mydemoapi

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST


interface ApiHelper {
    @POST("/api/auth/login")
    suspend fun login(
        @Body loginDataa: LoginDataa
    ) : Response<LoginResponce>
}