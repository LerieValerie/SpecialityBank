package com.valerie.specialitybank.domain.usecase

import com.valerie.specialitybank.domain.repository.LoadFromDbRepository

class LoadSpecialityListByWorkerIdUseCase(private val loadFromDbRepository: LoadFromDbRepository) {
    operator fun invoke(workerId : Int) =
        loadFromDbRepository.loadSpecialityListByWorkerId(workerId)

}