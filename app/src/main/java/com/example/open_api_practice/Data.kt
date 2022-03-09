package com.example.open_api_practice

class Data {
    var city = listOf("서울특별시","경기도")
    var town = listOf("송파구")
}

data class Item(val Code: String, val Attract : String)


class ApartData{

    private var apartName : String? = null
    private var adress : String? = null
    private var price : String? = null

    fun setApartName(apartName : String){
        this.apartName = apartName
    }

    fun setAdress(adress : String){
        this.adress = adress
    }
}

