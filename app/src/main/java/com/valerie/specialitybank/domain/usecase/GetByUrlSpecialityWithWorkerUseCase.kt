package com.valerie.specialitybank.domain.usecase

import com.valerie.specialitybank.domain.repository.SpecialityWithWorkerRemoteRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
class GetByUrlSpecialityWithWorkerUseCase(
        private val specialityWithWorkerRemoteRepository: SpecialityWithWorkerRemoteRepository,
        private val dispatcher: CoroutineDispatcher
) {
    suspend operator fun invoke() =
            withContext(dispatcher) {
                specialityWithWorkerRemoteRepository.getByUrl()
            }

}

