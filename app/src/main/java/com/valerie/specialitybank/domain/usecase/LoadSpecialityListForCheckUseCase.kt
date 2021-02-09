package com.valerie.specialitybank.domain.usecase

import com.valerie.specialitybank.domain.entity.Speciality
import com.valerie.specialitybank.domain.repository.SpecialityRepository

class LoadSpecialityListForCheckUseCase(private val specialityRepository: SpecialityRepository) {
    suspend operator fun invoke() : List<Speciality> {
        return specialityRepository.loadSpecialityListForCheck()
    }
}