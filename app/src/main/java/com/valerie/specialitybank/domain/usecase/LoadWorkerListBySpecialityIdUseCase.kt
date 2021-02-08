package com.valerie.specialitybank.domain.usecase

import com.valerie.specialitybank.domain.repository.LoadFromDbRepository

class LoadWorkerListBySpecialityIdUseCase(private val loadFromDbRepository: LoadFromDbRepository) {
    operator fun invoke(specialityId : Int) =
        loadFromDbRepository.loadWorkerListBySpecialityId(specialityId)

}