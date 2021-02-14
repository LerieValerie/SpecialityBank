package com.valerie.specialitybank.presentation.speciality

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.valerie.specialitybank.domain.usecase.LoadSpecialityByIdUseCase
import com.valerie.specialitybank.domain.usecase.LoadWorkerListBySpecialityIdUseCase
import com.valerie.specialitybank.presentation.view.toView
import kotlinx.coroutines.flow.map

class SpecialityViewModel(
    private val specialityId: Int,
    private val loadById: LoadSpecialityByIdUseCase,
    private val loadWorkerListById: LoadWorkerListBySpecialityIdUseCase
) : ViewModel() {

    fun loadSpeciality() = loadById(specialityId).map {
        it?.toView()
    }.asLiveData()

    fun loadWorkerList() = loadWorkerListById(specialityId).map {
        it.map { worker ->
            worker.toView()
        }
    }.asLiveData()
}

