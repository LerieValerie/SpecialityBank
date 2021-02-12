package com.valerie.specialitybank.di

import com.valerie.specialitybank.domain.usecase.*
import kotlinx.coroutines.*
import org.koin.dsl.module

val domainModule = module {
    single { Dispatchers.Default }

    single { SaveToDbSpecialityWithWorkerUseCase(get(), get(), get(), get()) }
    single { GetByUrlSpecialityWithWorkerUseCase(get(), get()) }
    single { SaveToDbFromRemoteSpecialityWithWorkerUseCase(get(), get()) }
    single { LoadSpecialityListUseCase(get(), get()) }
    single { ClearAllUseCase(get(), get(), get()) }
    single { LoadSpecialityByIdUseCase(get(), get()) }
    single { LoadWorkerListBySpecialityIdUseCase(get(), get()) }
    single { LoadWorkerByIdUseCase(get(), get()) }
    single { LoadSpecialityListByWorkerIdUseCase(get(), get()) }
    single { ReloadFromRemoteUseCase(get(), get()) }
}