package com.valerie.specialitybank.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    const val BASE_API_URL =
        "https://gist.githubusercontent.com/LerieValerie/c28bb5e9bb29986d7adfdd6ab5548255/raw/d1d10e1bedf7a2061c75f36df486b7d1c8faf7d0/"

    fun buildApi(baseUrl: String): NetInterface {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(NetInterface::class.java)
    }
}