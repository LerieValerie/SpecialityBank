package com.valerie.specialitybank.domain.usecase

import com.valerie.specialitybank.domain.entity.Speciality
import com.valerie.specialitybank.domain.repository.SpecialityRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class LoadSpecialityListForCheckUseCase(
    private val specialityRepository: SpecialityRepository,
    private val dispatcher: CoroutineDispatcher
) {
    suspend operator fun invoke(): List<Speciality> =
        withContext(dispatcher) {
            specialityRepository.loadSpecialityListForCheck()
        }
}