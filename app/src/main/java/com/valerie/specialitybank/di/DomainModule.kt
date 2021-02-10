package com.valerie.specialitybank.di

import com.valerie.specialitybank.data.local.SpecialityWorkerDatabase
import com.valerie.specialitybank.data.local.repository.JoinRepositoryImpl
import com.valerie.specialitybank.data.local.repository.SpecialityRepositoryImpl
import com.valerie.specialitybank.data.local.repository.WorkerRepositoryImpl
import com.valerie.specialitybank.data.remote.RetrofitBuilder
import com.valerie.specialitybank.data.remote.repository.SpecialityWithWorkerRemoteRepositoryImpl
import com.valerie.specialitybank.domain.repository.*
import com.valerie.specialitybank.domain.usecase.*
import com.valerie.specialitybank.presentation.speciality.SpecialityViewModel
import com.valerie.specialitybank.presentation.specialityroster.SpecialityRosterViewModel
import com.valerie.specialitybank.presentation.worker.WorkerViewModel
import kotlinx.coroutines.*
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.bind
import org.koin.dsl.module

val domainModule = module {
    single { Dispatchers.Default }

    factory { SaveToDbSpecialityWithWorkerUseCase(get(), get(), get(), get()) }
    factory { GetByUrlSpecialityWithWorkerUseCase(get(), get()) }
    factory { SaveToDbFromRemoteSpecialityWithWorkerUseCase(get(), get()) }
    factory { LoadSpecialityListUseCase(get(), get()) }
    factory { LoadSpecialityListForCheckUseCase(get(), get()) }
    factory { ClearAllUseCase(get(), get(), get()) }
    factory { LoadSpecialityByIdUseCase(get(), get()) }
    factory { LoadWorkerListBySpecialityIdUseCase(get(), get()) }
    factory { LoadWorkerByIdUseCase(get(), get()) }
    factory { LoadSpecialityListByWorkerIdUseCase(get(), get()) }
    factory { ReloadFromRemoteUseCase(get(), get()) }
}