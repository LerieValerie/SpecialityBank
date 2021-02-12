package com.valerie.specialitybank.domain.usecase

import com.valerie.specialitybank.domain.repository.WorkerRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.flowOn

class LoadSpecialityListByWorkerIdUseCase(
        private val workerRepository: WorkerRepository,
        private val dispatcher: CoroutineDispatcher
) {
    operator fun invoke(workerId : Int) =
        workerRepository.loadSpecialityListByWorkerId(workerId).flowOn(dispatcher)

}