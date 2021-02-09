package com.valerie.specialitybank.data.remote.repository

import com.valerie.specialitybank.data.remote.NetInterface
import com.valerie.specialitybank.domain.entity.Speciality
import com.valerie.specialitybank.domain.entity.Worker
import com.valerie.specialitybank.domain.repository.SpecialityWithWorkerRemoteRepository

class SpecialityWithWorkerRemoteRepositoryImpl(
    private val api : NetInterface
) : SpecialityWithWorkerRemoteRepository {

    override suspend fun getByUrl() : Pair<List<Speciality>, List<Worker>> {
        return try {
            val response = api.getWorker()
            val specialityList = response.toSpecialityList()
            val workerList = response.toWorkerList()
            Pair(specialityList, workerList)
        }
        catch (throwable: Throwable) {
            Pair(listOf(), listOf())
        }
    }
}