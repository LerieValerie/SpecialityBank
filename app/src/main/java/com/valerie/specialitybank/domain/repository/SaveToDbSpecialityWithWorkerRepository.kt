package com.valerie.specialitybank.domain.repository

import com.valerie.specialitybank.domain.entity.Speciality
import com.valerie.specialitybank.domain.entity.Worker

interface SaveToDbSpecialityWithWorkerRepository {
    suspend fun save(workerList : List<Worker>, specialityList : List<Speciality>)
}