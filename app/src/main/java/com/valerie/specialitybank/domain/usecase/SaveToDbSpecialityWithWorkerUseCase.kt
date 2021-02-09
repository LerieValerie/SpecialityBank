package com.valerie.specialitybank.domain.usecase

import com.valerie.specialitybank.domain.entity.Speciality
import com.valerie.specialitybank.domain.entity.Worker
import com.valerie.specialitybank.domain.repository.JoinRepository
import com.valerie.specialitybank.domain.repository.SpecialityRepository
import com.valerie.specialitybank.domain.repository.WorkerRepository

class SaveToDbSpecialityWithWorkerUseCase(
    private val specialityRepository: SpecialityRepository,
    private val workerRepository: WorkerRepository,
    private val joinRepository: JoinRepository) {

    suspend operator fun invoke(specialityList : List<Speciality>, workerList : List<Worker>){
        specialityRepository.saveSpecialityList(specialityList)
        workerRepository.saveWorkerList(workerList)
        joinRepository.saveJoinList(specialityList, workerList)
    }


}