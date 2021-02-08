package com.valerie.specialitybank.presentation.specialityroster

import androidx.lifecycle.*
import com.valerie.specialitybank.domain.entity.Speciality
import com.valerie.specialitybank.domain.entity.Worker
import com.valerie.specialitybank.domain.usecase.*
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class SpecialityRosterViewModel(
        private val getFromRemoteAndSave : SaveToDbFromRemoteSpecialityWithWorkerUseCase,
        private val loadSpecialityList : LoadSpecialityListUseCase,
        private val loadForCheck : LoadSpecialityListForCheckUseCase,
        private val clearAll : ClearAllUseCase
) : ViewModel() {

//    val a = MutableLiveData<List<Speciality>>()
//    lateinit var aa : LiveData<List<Speciality>>

//    init {
//        load()
//    }

    fun getFromRemoteAndSaveToDb() {
        viewModelScope.launch {
            val specialityList = loadForCheck()
//            if (specialityList.isNotEmpty()) {
//                clearAll()
//            }
            if (specialityList.isEmpty()) {
                getFromRemoteAndSave()
            }
        }
    }

    fun load() = loadSpecialityList().asLiveData()
//    fun load() {
//    aa = loadSpecialityList().asLiveData()
//    }


//    fun save() {
//        viewModelScope.launch {
//            workerList.value?.let { w : List<Worker> ->
//                specialityList.value?.let { s : List<Speciality> ->
//                    save(workerList = w, specialityList = s)
//                }
//            }
//        }
//    }
}

