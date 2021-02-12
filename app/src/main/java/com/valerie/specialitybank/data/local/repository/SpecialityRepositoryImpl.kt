package com.valerie.specialitybank.data.local.repository

import com.valerie.specialitybank.data.local.SpecialityWorkerDatabase
import com.valerie.specialitybank.data.local.converter.toEntity
import com.valerie.specialitybank.data.local.converter.toModel
import com.valerie.specialitybank.domain.entity.Speciality
import com.valerie.specialitybank.domain.entity.Worker
import com.valerie.specialitybank.domain.repository.SpecialityRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class SpecialityRepositoryImpl(private val dbInstance : SpecialityWorkerDatabase) : SpecialityRepository {

    override fun loadSpecialityList(): Flow<List<Speciality>> =
        dbInstance.specialityDao().loadSpeciality().map { it ->
            it.map { specialityModel ->
                specialityModel.toEntity()
            }
        }

    override suspend fun loadSpecialityListForCheck(): List<Speciality> =
        dbInstance.specialityDao().loadSpecialityListForCheck().map { specialityModel ->
            specialityModel.toEntity()
        }

    override fun loadSpecialityById(specialityId: Int): Flow<Speciality?> =
        dbInstance.specialityDao().loadSpecialityById(specialityId).map { it?.toEntity() }

    override fun loadWorkerListBySpecialityId(specialityId: Int): Flow<List<Worker>> =
        dbInstance.specialityDao().loadWorkerListBySpecialityId(specialityId).map {
            it?.workerList?.map { workerModel ->
                workerModel.toEntity()
            } ?: listOf()
        }

    override suspend fun deleteSpeciality() {
        dbInstance.specialityDao().deleteAllSpeciality()
    }

    override suspend fun saveSpecialityList(specialityList: List<Speciality>) {
        val specialityModelList = specialityList.map { it.toModel() }

        dbInstance.specialityDao().saveSpeciality(specialityModelList)
    }


}

