package com.valerie.specialitybank.data.local.repository

import com.valerie.specialitybank.data.local.SpecialityWorkerDatabase
import com.valerie.specialitybank.data.local.converter.toSpecialityWorkerJoinList
import com.valerie.specialitybank.domain.entity.Speciality
import com.valerie.specialitybank.domain.entity.Worker
import com.valerie.specialitybank.domain.repository.JoinRepository

class JoinRepositoryImpl(private val dbInstance : SpecialityWorkerDatabase) : JoinRepository {
    override suspend fun saveJoinList(specialityList: List<Speciality>, workerList: List<Worker>) {
        val joinList = toSpecialityWorkerJoinList(workerList, specialityList)

        dbInstance.joinDao().saveJoin(joinList)
    }
}