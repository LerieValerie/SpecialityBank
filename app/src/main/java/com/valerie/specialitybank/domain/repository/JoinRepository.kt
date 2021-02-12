package com.valerie.specialitybank.domain.repository

import com.valerie.specialitybank.domain.entity.Speciality
import com.valerie.specialitybank.domain.entity.Worker

interface JoinRepository {
    suspend fun saveJoinList(specialityList: List<Speciality>, workerList: List<Worker>)
}