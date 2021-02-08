package com.valerie.specialitybank.domain.repository

import com.valerie.specialitybank.domain.entity.Speciality
import com.valerie.specialitybank.domain.entity.Worker

interface GetByUrlSpecialityWithWorkerRepository {
    suspend fun getByUrl() : Pair<List<Speciality>, List<Worker>>
}