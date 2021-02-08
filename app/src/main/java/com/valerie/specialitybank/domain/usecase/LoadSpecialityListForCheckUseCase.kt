package com.valerie.specialitybank.domain.usecase

import com.valerie.specialitybank.domain.entity.Speciality
import com.valerie.specialitybank.domain.repository.LoadFromDbRepository

class LoadSpecialityListForCheckUseCase(private val loadRepository : LoadFromDbRepository) {
    suspend operator fun invoke() : List<Speciality> {
        return loadRepository.loadSpecialityListForCheck()
    }
}