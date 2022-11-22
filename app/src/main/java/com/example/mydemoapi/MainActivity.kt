package com.example.mydemoapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_Login.setOnClickListener{
            val user = et_user.text.toString().trim()
            val pas = et_pass.text.toString().trim()

            if(user.isEmpty()) {
                et_user.error = "Enter user"
                et_user.requestFocus()
            } else if(pas.isEmpty()) {
                et_pass.error = "Enter pass"
                et_pass.requestFocus()
            } else {
                val quotesApi = RetrofitHelper.getInstance().create(ApiHelper::class.java)
                // launching a new coroutine
                GlobalScope.launch(Dispatchers.Main) {

                    val result = quotesApi.login(LoginDataa(user,pas,R.string.token.toString(),1,3,""))
                    println("Top 1 server ${result.body()}")
                    if (result.body()?.messageCode == "AUTH__SUCCESS"){
                        Toast.makeText(applicationContext,"ggg", Toast.LENGTH_LONG).show()
                    }
                    else{
                        Toast.makeText(applicationContext,"ttt", Toast.LENGTH_LONG).show()
                    }

                }

            }
        }
    }
    object RetrofitHelper {

        val baseUrl = "https://gps.gotrack.vn"

        fun getInstance(): Retrofit {
            return Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                // we need to add converter factory to
                // convert JSON object to Java object
                .build()
        }
    }
}