package com.valerie.specialitybank.di

import com.valerie.specialitybank.data.local.SpecialityWorkerDatabase
import com.valerie.specialitybank.data.local.repository.JoinRepositoryImpl
import com.valerie.specialitybank.data.local.repository.SpecialityRepositoryImpl
import com.valerie.specialitybank.data.local.repository.WorkerRepositoryImpl
import com.valerie.specialitybank.data.remote.RetrofitBuilder
import com.valerie.specialitybank.data.remote.repository.SpecialityWithWorkerRemoteRepositoryImpl
import com.valerie.specialitybank.domain.repository.JoinRepository
import com.valerie.specialitybank.domain.repository.SpecialityRepository
import com.valerie.specialitybank.domain.repository.SpecialityWithWorkerRemoteRepository
import com.valerie.specialitybank.domain.repository.WorkerRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import org.koin.android.ext.koin.androidContext
import org.koin.core.qualifier.named
import org.koin.dsl.bind
import org.koin.dsl.module

val dataModule = module {
    val apiUrl = "apiUrl"
    single(named(apiUrl)) { RetrofitBuilder.BASE_API_URL }
    single(named("appScope")) { CoroutineScope(SupervisorJob()) }
    single { SpecialityWorkerDatabase.newInstance(androidContext()) }
    single { RetrofitBuilder.buildApi(get(named(apiUrl))) }

    single { SpecialityWithWorkerRemoteRepositoryImpl(get()) } bind SpecialityWithWorkerRemoteRepository::class
    single { SpecialityRepositoryImpl(get()) } bind SpecialityRepository::class
    single { WorkerRepositoryImpl(get()) } bind WorkerRepository::class
    single { JoinRepositoryImpl(get()) } bind JoinRepository::class
}