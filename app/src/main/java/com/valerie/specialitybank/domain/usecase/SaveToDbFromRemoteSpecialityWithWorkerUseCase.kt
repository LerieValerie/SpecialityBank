package com.valerie.specialitybank.domain.usecase

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SaveToDbFromRemoteSpecialityWithWorkerUseCase(
        private val getByUrl: GetByUrlSpecialityWithWorkerUseCase,
        private val saveToDb: SaveToDbSpecialityWithWorkerUseCase
) {
    suspend operator fun invoke() {
        val pairResponse = getByUrl.invoke()
        saveToDb(pairResponse.first, pairResponse.second)
    }
}