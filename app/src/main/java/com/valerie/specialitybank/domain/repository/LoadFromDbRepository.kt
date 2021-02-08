package com.valerie.specialitybank.domain.repository

import com.valerie.specialitybank.domain.entity.Speciality
import com.valerie.specialitybank.domain.entity.Worker
import kotlinx.coroutines.flow.Flow

interface LoadFromDbRepository {
    fun loadSpecialityList() : Flow<List<Speciality>>
    suspend fun loadSpecialityListForCheck() : List<Speciality>
    fun loadSpecialityById(specialityId : Int) : Flow<Speciality>
    fun loadWorkerListBySpecialityId(specialityId : Int) : Flow<List<Worker>>
    fun loadWorkerById(workerId : Int) : Flow<Worker>
    fun loadSpecialityListByWorkerId(workerId: Int) : Flow<List<Speciality>>
}