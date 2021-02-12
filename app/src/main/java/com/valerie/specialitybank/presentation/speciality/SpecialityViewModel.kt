package com.valerie.specialitybank.presentation.speciality

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.valerie.specialitybank.domain.usecase.LoadSpecialityByIdUseCase
import com.valerie.specialitybank.domain.usecase.LoadWorkerListBySpecialityIdUseCase

class SpecialityViewModel(
    private val specialityId: Int,
    private val loadById: LoadSpecialityByIdUseCase,
    private val loadWorkerListById: LoadWorkerListBySpecialityIdUseCase
) : ViewModel() {

    fun loadSpeciality() = loadById(specialityId).asLiveData()

    fun loadWorkerList() = loadWorkerListById(specialityId).asLiveData()
}

