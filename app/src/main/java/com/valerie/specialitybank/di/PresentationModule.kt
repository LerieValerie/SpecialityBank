package com.valerie.specialitybank.di

import com.valerie.specialitybank.presentation.speciality.SpecialityViewModel
import com.valerie.specialitybank.presentation.specialityroster.SpecialityRosterViewModel
import com.valerie.specialitybank.presentation.worker.WorkerViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { SpecialityRosterViewModel(get(), get(), get(), get(), get()) }
    viewModel { (specialityId: Int) -> SpecialityViewModel(specialityId, get(), get()) }
    viewModel { (workerId: Int) -> WorkerViewModel(workerId, get(), get()) }
}