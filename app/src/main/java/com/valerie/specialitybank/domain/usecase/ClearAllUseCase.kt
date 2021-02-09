package com.valerie.specialitybank.domain.usecase

import com.valerie.specialitybank.domain.repository.SpecialityRepository
import com.valerie.specialitybank.domain.repository.WorkerRepository

class ClearAllUseCase(private val workerRepository: WorkerRepository, private val specialityRepository: SpecialityRepository) {
    suspend operator fun invoke() {
        workerRepository.deleteWorker()
        specialityRepository.deleteSpeciality()
    }
}