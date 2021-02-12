package com.valerie.specialitybank.domain.usecase

import com.valerie.specialitybank.domain.repository.SpecialityRepository
import com.valerie.specialitybank.domain.repository.WorkerRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class ClearAllUseCase(
    private val workerRepository: WorkerRepository,
    private val specialityRepository: SpecialityRepository,
    private val dispatcher: CoroutineDispatcher
) {
    suspend operator fun invoke() {
        withContext(dispatcher) {
            workerRepository.deleteWorker()
            specialityRepository.deleteSpeciality()
        }
    }
}