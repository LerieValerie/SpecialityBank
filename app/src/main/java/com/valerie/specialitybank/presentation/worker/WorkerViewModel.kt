package com.valerie.specialitybank.presentation.worker

import androidx.lifecycle.*
import com.valerie.specialitybank.domain.usecase.*

class WorkerViewModel(
        private val workerId: Int,
        private val loadById : LoadWorkerByIdUseCase,
        private val loadSpecialityListById : LoadSpecialityListByWorkerIdUseCase
) : ViewModel() {

        fun loadWorker() = loadById(workerId).asLiveData()

        fun loadSpecialityList() = loadSpecialityListById(workerId).asLiveData()
}

