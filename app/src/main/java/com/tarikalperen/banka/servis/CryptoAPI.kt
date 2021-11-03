package com.tarikalperen.banka.servis

import com.tarikalperen.banka.model.CrytoModel
import retrofit2.Call
import retrofit2.http.GET
import io.reactivex.Observable


interface CryptoAPI {

    @GET("prices?key=a4da7af7fd89f355b28ca16816dbf6698876478c")
    fun getData(): Call<List<CrytoModel>>
}
