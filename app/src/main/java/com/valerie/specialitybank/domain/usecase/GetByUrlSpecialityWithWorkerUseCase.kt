package com.valerie.specialitybank.domain.usecase

import com.valerie.specialitybank.domain.repository.GetByUrlSpecialityWithWorkerRepository

class GetByUrlSpecialityWithWorkerUseCase(private val getByUrlSpecialityWithWorkerRepository: GetByUrlSpecialityWithWorkerRepository) {

    suspend operator fun invoke() =
            getByUrlSpecialityWithWorkerRepository.getByUrl()
}