package com.valerie.specialitybank.domain.repository

import com.valerie.specialitybank.domain.entity.Speciality
import com.valerie.specialitybank.domain.entity.Worker

interface SpecialityWithWorkerRemoteRepository {
    suspend fun getByUrl() : Pair<List<Speciality>, List<Worker>>
}