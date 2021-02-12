package com.valerie.specialitybank.domain.usecase

import com.valerie.specialitybank.domain.repository.SpecialityRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.flowOn

class LoadSpecialityListUseCase(
    private val specialityRepository: SpecialityRepository,
    private val dispatcher: CoroutineDispatcher
) {
    operator fun invoke() = specialityRepository.loadSpecialityList().flowOn(dispatcher)
}