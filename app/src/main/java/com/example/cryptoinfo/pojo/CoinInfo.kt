package com.example.cryptoinfo.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CoinInfo(

    @SerializedName("Name")
    @Expose
    var name: String? = null,

)