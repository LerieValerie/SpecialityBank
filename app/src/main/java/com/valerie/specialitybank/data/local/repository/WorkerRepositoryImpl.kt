package com.valerie.specialitybank.data.local.repository

import com.valerie.specialitybank.data.local.SpecialityWorkerDatabase
import com.valerie.specialitybank.data.local.converter.toEntity
import com.valerie.specialitybank.data.local.converter.toWorkerModelList
import com.valerie.specialitybank.domain.entity.Speciality
import com.valerie.specialitybank.domain.entity.Worker
import com.valerie.specialitybank.domain.repository.WorkerRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class WorkerRepositoryImpl(private val dbInstance: SpecialityWorkerDatabase) : WorkerRepository {
    override fun loadWorkerById(workerId: Int): Flow<Worker?> =
        dbInstance.workerDao().loadWorkerById(workerId).map { it?.toEntity() }

    override fun loadSpecialityListByWorkerId(workerId: Int): Flow<List<Speciality>> =
        dbInstance.workerDao().loadSpecialityListByWorkerId(workerId).map {
            it?.specialityList?.map { specialityModel ->
                specialityModel.toEntity()
            } ?: listOf()
        }

    override suspend fun deleteWorker() {
        dbInstance.workerDao().deleteAllWorker()
    }

    override suspend fun saveWorkerList(workerList: List<Worker>) {
        val workerModelList = workerList.toWorkerModelList()

        dbInstance.workerDao().saveWorker(workerModelList)
    }
}