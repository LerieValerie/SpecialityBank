package com.valerie.specialitybank.data.local.repository

import com.valerie.specialitybank.data.local.SpecialityWorkerDatabase
import com.valerie.specialitybank.data.local.converter.toEntity
import com.valerie.specialitybank.domain.entity.Speciality
import com.valerie.specialitybank.domain.entity.Worker
import com.valerie.specialitybank.domain.repository.LoadFromDbRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LoadFromDbRepositoryImpl(private val dbInstance : SpecialityWorkerDatabase) : LoadFromDbRepository {
    override fun loadSpecialityList(): Flow<List<Speciality>> =
        dbInstance.specialityWorkerDao().loadSpeciality().map { it ->
            it.map { specialityModel ->
                specialityModel.toEntity()
            }
        }

    override suspend fun loadSpecialityListForCheck(): List<Speciality> =
        dbInstance.specialityWorkerDao().loadSpecialityListForCheck().map { specialityModel ->
            specialityModel.toEntity()
        }

    override fun loadSpecialityById(specialityId: Int): Flow<Speciality> =
        dbInstance.specialityWorkerDao().loadSpecialityById(specialityId).map { it.toEntity() }

    override fun loadWorkerListBySpecialityId(specialityId: Int): Flow<List<Worker>> =
        dbInstance.specialityWorkerDao().loadWorkerListBySpecialityId(specialityId).map {
            it.workerList.map { workerModel ->
                workerModel.toEntity()
            }
        }

    override fun loadWorkerById(workerId: Int): Flow<Worker> =
        dbInstance.workerSpecialityDao().loadWorkerById(workerId).map { it.toEntity() }

    override fun loadSpecialityListByWorkerId(workerId: Int): Flow<List<Speciality>> =
            dbInstance.workerSpecialityDao().loadSpecialityListByWorkerId(workerId).map {
                it.specialityList.map { specialityModel ->
                    specialityModel.toEntity()
                }
            }
}