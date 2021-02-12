package com.valerie.specialitybank.presentation.worker

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.valerie.specialitybank.domain.usecase.LoadSpecialityListByWorkerIdUseCase
import com.valerie.specialitybank.domain.usecase.LoadWorkerByIdUseCase

class WorkerViewModel(
    private val workerId: Int,
    private val loadById: LoadWorkerByIdUseCase,
    private val loadSpecialityListById: LoadSpecialityListByWorkerIdUseCase
) : ViewModel() {

    fun loadWorker() = loadById(workerId).asLiveData()

    fun loadSpecialityList() = loadSpecialityListById(workerId).asLiveData()
}

