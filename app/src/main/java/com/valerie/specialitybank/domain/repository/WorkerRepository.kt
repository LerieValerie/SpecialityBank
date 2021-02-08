package com.valerie.specialitybank.domain.repository

import com.valerie.specialitybank.domain.entity.Speciality
import com.valerie.specialitybank.domain.entity.Worker
import kotlinx.coroutines.flow.Flow

interface WorkerRepository {
    fun loadWorkerById(workerId : Int) : Flow<Worker>
    fun loadSpecialityListByWorkerId(workerId: Int) : Flow<List<Speciality>>

    suspend fun deleteWorker()

    suspend fun saveWorkerList(workerList : List<Worker>)
}