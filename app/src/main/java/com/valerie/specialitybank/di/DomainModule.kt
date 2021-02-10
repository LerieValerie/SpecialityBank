package com.valerie.specialitybank.di

import com.valerie.specialitybank.domain.usecase.*
import kotlinx.coroutines.*
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