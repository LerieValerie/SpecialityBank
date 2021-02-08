package com.valerie.specialitybank.domain.usecase

import com.valerie.specialitybank.domain.repository.ClearAllRepository

class ClearAllUseCase(private val clearAllRepository: ClearAllRepository) {
    suspend operator fun invoke() {
        clearAllRepository.clearAll()
    }
}