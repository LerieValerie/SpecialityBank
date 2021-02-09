package com.valerie.specialitybank.domain.usecase

import com.valerie.specialitybank.domain.repository.WorkerRepository

class LoadWorkerByIdUseCase(private val workerRepository: WorkerRepository) {
    operator fun invoke(workerId : Int) =
        workerRepository.loadWorkerById(workerId)

}