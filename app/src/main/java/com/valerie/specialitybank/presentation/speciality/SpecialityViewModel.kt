package com.valerie.specialitybank.presentation.speciality

import androidx.lifecycle.*
import com.valerie.specialitybank.domain.entity.Speciality
import com.valerie.specialitybank.domain.entity.Worker
import com.valerie.specialitybank.domain.usecase.*
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class SpecialityViewModel(
        private val specialityId: Int,
        private val loadById : LoadSpecialityByIdUseCase,
        private val loadWorkerListById : LoadWorkerListBySpecialityIdUseCase
) : ViewModel() {

        fun loadSpeciality() = loadById(specialityId).asLiveData()

        fun loadWorkerList() = loadWorkerListById(specialityId).asLiveData()
}

