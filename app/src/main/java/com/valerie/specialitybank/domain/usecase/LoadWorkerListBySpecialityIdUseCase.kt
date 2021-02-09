package com.valerie.specialitybank.domain.usecase

import com.valerie.specialitybank.domain.repository.SpecialityRepository

class LoadWorkerListBySpecialityIdUseCase(private val specialityRepository: SpecialityRepository) {
    operator fun invoke(specialityId : Int) =
        specialityRepository.loadWorkerListBySpecialityId(specialityId)

}