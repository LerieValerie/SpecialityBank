package com.valerie.specialitybank.data.remote

import com.google.gson.annotations.SerializedName

data class WorkerRootResponse(
        @SerializedName("response") val workerResponseList: List<WorkerResponse>
) {
    fun toSpecialityList() =
            workerResponseList.flatMap { it.specialityResponseList }.toSet().map { it.toEntity() }

    fun toWorkerList()  = workerResponseList.mapIndexed { i: Int, workerResponse: WorkerResponse ->
        workerResponse.toEntity(i + 1)
    }
}