package com.example.mydemoapi

import androidx.annotation.Keep

@Keep
data class LoginDataa(
    val username : String,
    val password : String,
    val tokenFireBase : String,
    val sessionType : Int,
    val type : Int,
    val code : String
)
