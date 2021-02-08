package com.valerie.specialitybank.domain.usecase

import com.valerie.specialitybank.domain.repository.SpecialityWithWorkerRemoteRepository

class GetByUrlSpecialityWithWorkerUseCase(private val specialityWithWorkerRemoteRepository: SpecialityWithWorkerRemoteRepository) {

    suspend operator fun invoke() =
            specialityWithWorkerRemoteRepository.getByUrl()
}