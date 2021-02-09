package com.valerie.specialitybank.domain.usecase

import com.valerie.specialitybank.domain.repository.SpecialityRepository

class LoadSpecialityListUseCase(private val specialityRepository: SpecialityRepository) {
    operator fun invoke() = specialityRepository.loadSpecialityList()
}