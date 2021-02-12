package com.valerie.specialitybank.presentation.specialityroster

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.valerie.specialitybank.domain.entity.Failure
import com.valerie.specialitybank.domain.usecase.ClearAllUseCase
import com.valerie.specialitybank.domain.usecase.LoadSpecialityListUseCase
import com.valerie.specialitybank.domain.usecase.ReloadFromRemoteUseCase
import com.valerie.specialitybank.domain.usecase.SaveToDbFromRemoteSpecialityWithWorkerUseCase
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class SpecialityRosterViewModel(
    private val getFromRemoteAndSave: SaveToDbFromRemoteSpecialityWithWorkerUseCase,
    private val loadSpecialityList: LoadSpecialityListUseCase,
    private val clearAll: ClearAllUseCase,
    private val reloadFromRemote: ReloadFromRemoteUseCase
) : ViewModel() {

    private val failureChannel = Channel<Failure>()

    val failureFlow
        get() = failureChannel.receiveAsFlow()

    fun load() = loadSpecialityList().asLiveData()

    fun delete() {
        viewModelScope.launch {
            clearAll()
        }
    }

    fun reloadFromRemoteFailure() {
        viewModelScope.launch {
            try {
                reloadFromRemote.invoke()
            } catch (failure: Failure) {
                failureChannel.send(failure)
            }
        }
    }

    fun getFromRemoteAndSaveWithFailure() {
        viewModelScope.launch {
            try {
                getFromRemoteAndSave.invoke()
            } catch (failure: Failure) {
                failureChannel.send(failure)
            }
        }
    }

}

