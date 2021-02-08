package com.valerie.specialitybank.domain.usecase

import com.valerie.specialitybank.domain.repository.LoadFromDbRepository

class LoadSpecialityByIdUseCase(private val loadFromDbRepository: LoadFromDbRepository) {
    operator fun invoke(specialityId : Int) =
        loadFromDbRepository.loadSpecialityById(specialityId)

}