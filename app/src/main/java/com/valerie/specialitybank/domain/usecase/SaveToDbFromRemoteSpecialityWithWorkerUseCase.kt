package com.valerie.specialitybank.domain.usecase

import com.valerie.specialitybank.domain.repository.GetByUrlSpecialityWithWorkerRepository
import com.valerie.specialitybank.domain.repository.SaveToDbSpecialityWithWorkerRepository

class SaveToDbFromRemoteSpecialityWithWorkerUseCase(
    private val getByUrl: GetByUrlSpecialityWithWorkerUseCase,
    private val saveToDb: SaveToDbSpecialityWithWorkerUseCase
) {
    suspend operator fun invoke() {
        val pairResponse = getByUrl()
        saveToDb.invoke(pairResponse.second, pairResponse.first)
    }
}