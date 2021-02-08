package com.valerie.specialitybank.domain.usecase

import com.valerie.specialitybank.domain.repository.LoadFromDbRepository

class LoadSpecialityListUseCase(private val loadRepository : LoadFromDbRepository) {
    operator fun invoke() = loadRepository.loadSpecialityList()
}