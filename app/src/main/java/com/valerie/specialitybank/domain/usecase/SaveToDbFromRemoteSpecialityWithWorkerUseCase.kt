package com.valerie.specialitybank.domain.usecase

class SaveToDbFromRemoteSpecialityWithWorkerUseCase(
    private val getByUrl: GetByUrlSpecialityWithWorkerUseCase,
    private val saveToDb: SaveToDbSpecialityWithWorkerUseCase
) {
    suspend operator fun invoke() {
        val pairResponse = getByUrl()
        saveToDb.invoke(pairResponse.second, pairResponse.first)
    }
}