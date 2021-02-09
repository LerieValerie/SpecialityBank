package com.valerie.specialitybank.domain.usecase

import com.valerie.specialitybank.domain.repository.WorkerRepository

class LoadSpecialityListByWorkerIdUseCase(private val workerRepository: WorkerRepository) {
    operator fun invoke(workerId : Int) =
        workerRepository.loadSpecialityListByWorkerId(workerId)

}