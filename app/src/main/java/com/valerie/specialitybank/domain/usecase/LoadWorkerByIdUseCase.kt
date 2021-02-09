package com.valerie.specialitybank.domain.usecase

import com.valerie.specialitybank.domain.repository.WorkerRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.flowOn

class LoadWorkerByIdUseCase(
        private val workerRepository: WorkerRepository,
        private val dispatcher: CoroutineDispatcher

) {
    operator fun invoke(workerId : Int) =
        workerRepository.loadWorkerById(workerId).flowOn(dispatcher)

}