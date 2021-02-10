package com.valerie.specialitybank.domain.usecase

class SaveToDbFromRemoteSpecialityWithWorkerUseCase(
        private val getByUrl: GetByUrlSpecialityWithWorkerUseCase,
        private val saveToDb: SaveToDbSpecialityWithWorkerUseCase
) {
    suspend operator fun invoke() {
        val pairResponse = getByUrl.invoke()
        saveToDb(pairResponse.first, pairResponse.second)
    }
}