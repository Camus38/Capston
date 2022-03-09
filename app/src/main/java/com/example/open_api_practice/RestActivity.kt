package com.example.open_api_practice

import android.os.Bundle
import android.os.PersistableBundle

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

val data = Data()

interface RestApi{
    @GET("/")
    fun getRoot() : Call<String>
    @GET("/")
    fun getRoot2() : String


    @GET("/getRTMSDataSvcAptTradeDev?LAWD_CD={code}&DEAL_YMD={ymd}&serviceKey={service}")
    suspend fun listItem(code: String,ymd : String,@Path("service")service:String) : List<Item>

    @GET("{Key}/1/10")
    fun getApartment(@Path("Key") Key : String) : List<ApartData>


}

class RestActivity : AppCompatActivity(){
    private lateinit var myViewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        myViewModel = ViewModelProvider(this).get(MyViewModel::class.java)

    }
}