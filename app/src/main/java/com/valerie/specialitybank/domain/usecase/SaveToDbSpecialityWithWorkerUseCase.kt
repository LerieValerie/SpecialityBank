package com.valerie.specialitybank.domain.usecase

import com.valerie.specialitybank.domain.entity.Speciality
import com.valerie.specialitybank.domain.entity.Worker
import com.valerie.specialitybank.domain.repository.SaveToDbSpecialityWithWorkerRepository

class SaveToDbSpecialityWithWorkerUseCase(private val saveToDbSpecialityWithWorkerRepository: SaveToDbSpecialityWithWorkerRepository) {

    suspend operator fun invoke(workerList : List<Worker>, specialityList : List<Speciality>) =
            saveToDbSpecialityWithWorkerRepository.save(workerList, specialityList)
}