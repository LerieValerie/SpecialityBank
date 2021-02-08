package com.valerie.specialitybank.data.local.repository

import com.valerie.specialitybank.data.local.SpecialityWorkerDatabase
import com.valerie.specialitybank.domain.repository.ClearAllRepository

class ClearAllRepositoryImpl(private val dbInstance : SpecialityWorkerDatabase) : ClearAllRepository {
    override suspend fun clearAll() {
        dbInstance.generalDao().deleteAll()
    }
}