package com.valerie.specialitybank.domain.usecase

import com.valerie.specialitybank.domain.repository.SpecialityRepository

class LoadSpecialityByIdUseCase(private val specialityRepository: SpecialityRepository) {
    operator fun invoke(specialityId : Int) =
        specialityRepository.loadSpecialityById(specialityId)

}