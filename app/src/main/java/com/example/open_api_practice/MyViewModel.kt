package com.example.open_api_practice

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory


class MyViewModel :ViewModel() {

    private val Key = "lPtJ%2BHQfZafMKSK1KFkwGrTV4GZRnmBMPsUGcCIPR0tyDS5VEHvZv86KY9ICm3wTlPpJXlridmrwcfJ%2F1o%2Bjxw%3D%3D"
    private val baseURL =
        "http://openapi.molit.go.kr/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptTradeDev?LAWD_CD=11110&DEAL_YMD=201512&serviceKey=${Key}"

    private lateinit var api: RestApi
    val itemsListData = MutableLiveData<ArrayList<Item>>()
    val items = ArrayList<Item>()


    init {

        items.add(Item("서울", "송파구"))
        items.add(Item("서울", "강남구"))
    }

    /*fun addItem(item: Item){
        items.add(item)
        itemsListData.value = items
    }

    fun updateItem(pos: Int,item: Item){
        items[pos] = item
        itemsListData.value = items
    }

    fun deleteItem(pos: Int){
        items.removeAt(pos)
        itemsListData.value = items
    }*/

    private fun retrofitinit() { //retrofit 객체 생성
        val retrofit = Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(SimpleXmlConverterFactory.create())
            .addConverterFactory(ScalarsConverterFactory.create())
            .build()

        api = retrofit.create(RestApi::class.java)

        api.getRoot().enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {

            }

            override fun onFailure(call: Call<String>, t: Throwable) {

            }
        })


        fun refreshData() {
            viewModelScope.launch {
                try {

                } catch (e: Exception) {

                }
            }
        }

    }
}