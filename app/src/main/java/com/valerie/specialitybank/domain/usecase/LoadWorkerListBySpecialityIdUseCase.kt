package com.valerie.specialitybank.domain.usecase

import com.valerie.specialitybank.domain.repository.SpecialityRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.flowOn

class LoadWorkerListBySpecialityIdUseCase(
        private val specialityRepository: SpecialityRepository,
        private val dispatcher: CoroutineDispatcher
) {
    operator fun invoke(specialityId : Int) =
        specialityRepository.loadWorkerListBySpecialityId(specialityId).flowOn(dispatcher)

}