package com.valerie.specialitybank

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
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.bind
import org.koin.dsl.module

val generalModule = module {
    val apiUrl = "apiUrl"
    single(named(apiUrl)) { RetrofitBuilder.BASE_API_URL }
    single(named("appScope")) { CoroutineScope(SupervisorJob()) }
    single { SpecialityWorkerDatabase.newInstance(androidContext()) }
    single { RetrofitBuilder.buildApi(get(named(apiUrl)))}

    factory { SpecialityWithWorkerRemoteRepositoryImpl(get()) } bind SpecialityWithWorkerRemoteRepository::class
    factory { SpecialityRepositoryImpl(get()) } bind SpecialityRepository::class
    factory { WorkerRepositoryImpl(get()) } bind WorkerRepository::class
    factory { JoinRepositoryImpl(get()) } bind JoinRepository::class

    factory { SaveToDbSpecialityWithWorkerUseCase(get()) }
    factory { GetByUrlSpecialityWithWorkerUseCase(get()) }
    factory { SaveToDbFromRemoteSpecialityWithWorkerUseCase(get(), get()) }
    factory { LoadSpecialityListUseCase(get()) }
    factory { LoadSpecialityListForCheckUseCase(get()) }
    factory { ClearAllUseCase(get()) }
    factory { LoadSpecialityByIdUseCase(get()) }
    factory { LoadWorkerListBySpecialityIdUseCase(get()) }
    factory { LoadWorkerByIdUseCase(get()) }
    factory { LoadSpecialityListByWorkerIdUseCase(get()) }

    viewModel { SpecialityRosterViewModel(get(), get(), get(), get()) }
    viewModel { (specialityId: Int) -> SpecialityViewModel(specialityId, get(), get()) }
    viewModel { (workerId: Int) -> WorkerViewModel(workerId, get(), get()) }
}