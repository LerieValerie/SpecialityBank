package com.valerie.specialitybank.domain.usecase

class ReloadFromRemoteUseCase(
    private val clearAll: ClearAllUseCase,
    private val getFromRemoteAndSave: SaveToDbFromRemoteSpecialityWithWorkerUseCase

) {
    suspend operator fun invoke() {
        clearAll()
        getFromRemoteAndSave()
    }
}