package com.valerie.specialitybank.domain.usecase

import com.valerie.specialitybank.domain.repository.LoadFromDbRepository

class LoadWorkerByIdUseCase(private val loadFromDbRepository: LoadFromDbRepository) {
    operator fun invoke(workerId : Int) =
        loadFromDbRepository.loadWorkerById(workerId)

}