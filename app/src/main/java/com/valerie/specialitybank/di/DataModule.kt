package com.valerie.specialitybank.di

import com.valerie.specialitybank.data.local.SpecialityWorkerDatabase
import com.valerie.specialitybank.data.local.repository.JoinRepositoryImpl
import com.valerie.specialitybank.data.local.repository.SpecialityRepositoryImpl
import com.valerie.specialitybank.data.local.repository.WorkerRepositoryImpl
import com.valerie.specialitybank.data.remote.RetrofitBuilder
import com.valerie.specialitybank.data.remote.repository.SpecialityWithWorkerRemoteRepositoryImpl
import com.valerie.specialitybank.domain.repository.*
import kotlinx.coroutines.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.qualifier.named
import org.koin.dsl.bind
import org.koin.dsl.module

val dataModule = module {
    val apiUrl = "apiUrl"
    single(named(apiUrl)) { RetrofitBuilder.BASE_API_URL }
    single(named("appScope")) { CoroutineScope(SupervisorJob()) }
    single { SpecialityWorkerDatabase.newInstance(androidContext()) }
    single { RetrofitBuilder.buildApi(get(named(apiUrl)))}

    factory { SpecialityWithWorkerRemoteRepositoryImpl(get()) } bind SpecialityWithWorkerRemoteRepository::class
    factory { SpecialityRepositoryImpl(get()) } bind SpecialityRepository::class
    factory { WorkerRepositoryImpl(get()) } bind WorkerRepository::class
    factory { JoinRepositoryImpl(get()) } bind JoinRepository::class
}