package com.valerie.specialitybank.presentation.worker

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.valerie.specialitybank.domain.usecase.LoadSpecialityListByWorkerIdUseCase
import com.valerie.specialitybank.domain.usecase.LoadWorkerByIdUseCase
import com.valerie.specialitybank.presentation.view.toView
import kotlinx.coroutines.flow.map

class WorkerViewModel(
    private val workerId: Int,
    private val loadById: LoadWorkerByIdUseCase,
    private val loadSpecialityListById: LoadSpecialityListByWorkerIdUseCase
) : ViewModel() {

    fun loadWorker() = loadById(workerId).map { it?.toView() }.asLiveData()

    fun loadSpecialityList() = loadSpecialityListById(workerId).map {
        it.map {
            speciality -> speciality.toView()
        }
    }.asLiveData()
}

