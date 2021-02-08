package com.valerie.specialitybank.data.remote.repository

import com.valerie.specialitybank.data.remote.NetInterface
import com.valerie.specialitybank.domain.entity.Speciality
import com.valerie.specialitybank.domain.entity.Worker
import com.valerie.specialitybank.domain.repository.GetByUrlSpecialityWithWorkerRepository

class GetByUrlSpecialityWithWorkerRepositoryImpl(
    private val api : NetInterface
) : GetByUrlSpecialityWithWorkerRepository {

    override suspend fun getByUrl() : Pair<List<Speciality>, List<Worker>>{
        val response = api.getWorker()

        val specialityList = response.toSpecialityList()
        val workerList = response.toWorkerList()

        return Pair(specialityList, workerList)
    }
}