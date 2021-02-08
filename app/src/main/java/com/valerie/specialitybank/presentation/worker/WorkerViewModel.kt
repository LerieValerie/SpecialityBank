package com.valerie.specialitybank.presentation.worker

import androidx.lifecycle.*
import com.valerie.specialitybank.domain.entity.Speciality
import com.valerie.specialitybank.domain.entity.Worker
import com.valerie.specialitybank.domain.usecase.*
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class WorkerViewModel(
        private val workerId: Int,
        private val loadById : LoadWorkerByIdUseCase,
        private val loadSpecialityListById : LoadSpecialityListByWorkerIdUseCase
) : ViewModel() {

        fun loadWorker() = loadById(workerId).asLiveData()

        fun loadSpecialityList() = loadSpecialityListById(workerId).asLiveData()
}

