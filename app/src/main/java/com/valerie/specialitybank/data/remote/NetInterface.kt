package com.valerie.specialitybank.data.remote

import retrofit2.http.GET

interface NetInterface {
//    @GET("https://gitlab.65apps.com/65gb/static/raw/master/testTask.json")
    @GET("testTask.json")
    suspend fun getWorker() : WorkerRootResponse
}
