package com.example.mydemoapi

import androidx.annotation.Keep

@Keep
data class LoginResponce(
    val timestamp : String,
    val status : String,
    val datetime : String,
    val message : String,
    val messageCode : String,
    val result : Any
)
