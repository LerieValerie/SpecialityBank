package com.valerie.specialitybank.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    const val BASE_API_URL = "https://gitlab.65apps.com/65gb/static/raw/master/"

    fun buildApi(baseUrl: String): NetInterface {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(NetInterface::class.java)
    }
}