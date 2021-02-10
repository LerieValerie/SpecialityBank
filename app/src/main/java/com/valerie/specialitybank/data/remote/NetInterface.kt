package com.valerie.specialitybank.data.remote

import retrofit2.http.GET

interface NetInterface {
    @GET("specialityBank.json")
//    @GET("testTask.json")
    suspend fun getWorker() : WorkerRootResponse
}
