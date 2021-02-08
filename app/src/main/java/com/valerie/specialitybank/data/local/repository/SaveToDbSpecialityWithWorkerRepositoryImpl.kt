package com.valerie.specialitybank.data.local.repository

import com.valerie.specialitybank.data.local.SpecialityWorkerDatabase
import com.valerie.specialitybank.data.local.converter.toSpecialityModelList
import com.valerie.specialitybank.data.local.converter.toSpecialityWorkerJoinList
import com.valerie.specialitybank.data.local.converter.toWorkerModelList
import com.valerie.specialitybank.domain.entity.Speciality
import com.valerie.specialitybank.domain.entity.Worker
import com.valerie.specialitybank.domain.repository.SaveToDbSpecialityWithWorkerRepository

class SaveToDbSpecialityWithWorkerRepositoryImpl(
    private val dbInstance : SpecialityWorkerDatabase
) : SaveToDbSpecialityWithWorkerRepository {

    private val generalDao = dbInstance.generalDao()

    override suspend fun save(workerList : List<Worker>, specialityList : List<Speciality>) {
        val specialityModelList = specialityList.toSpecialityModelList()
        val workerModelList = workerList.toWorkerModelList()
        val joinList = toSpecialityWorkerJoinList(workerList, specialityList)

        generalDao.saveAll(specialityList = specialityModelList, workerList = workerModelList, joinList = joinList)
    }
}