package com.valerie.specialitybank.domain.usecase

import com.valerie.specialitybank.domain.entity.Speciality
import com.valerie.specialitybank.domain.entity.Worker
import com.valerie.specialitybank.domain.repository.JoinRepository
import com.valerie.specialitybank.domain.repository.SpecialityRepository
import com.valerie.specialitybank.domain.repository.WorkerRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class SaveToDbSpecialityWithWorkerUseCase(
    private val specialityRepository: SpecialityRepository,
    private val workerRepository: WorkerRepository,
    private val joinRepository: JoinRepository,
    private val dispatcher: CoroutineDispatcher
) {
    suspend operator fun invoke(specialityList: List<Speciality>, workerList: List<Worker>) {
        withContext(dispatcher) {
            specialityRepository.saveSpecialityList(specialityList)
            workerRepository.saveWorkerList(workerList)
            joinRepository.saveJoinList(specialityList, workerList)
        }
    }


}