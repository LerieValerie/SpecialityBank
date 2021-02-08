package com.valerie.specialitybank

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.valerie.specialitybank.data.local.SpecialityWorkerDatabase
import com.valerie.specialitybank.data.local.repository.ClearAllRepositoryImpl
import com.valerie.specialitybank.data.local.repository.LoadFromDbRepositoryImpl
import com.valerie.specialitybank.data.local.repository.SaveToDbSpecialityWithWorkerRepositoryImpl
import com.valerie.specialitybank.data.remote.RetrofitBuilder
import com.valerie.specialitybank.data.remote.RetrofitBuilder.BASE_API_URL
import com.valerie.specialitybank.data.remote.repository.GetByUrlSpecialityWithWorkerRepositoryImpl
import com.valerie.specialitybank.domain.repository.ClearAllRepository
import com.valerie.specialitybank.domain.repository.SaveToDbSpecialityWithWorkerRepository
import com.valerie.specialitybank.domain.repository.GetByUrlSpecialityWithWorkerRepository
import com.valerie.specialitybank.domain.repository.LoadFromDbRepository
import com.valerie.specialitybank.domain.usecase.*
import com.valerie.specialitybank.presentation.speciality.SpecialityViewModel
import com.valerie.specialitybank.presentation.specialityroster.SpecialityRosterViewModel
import com.valerie.specialitybank.presentation.worker.WorkerViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.core.qualifier.named
import org.koin.dsl.bind
import org.koin.dsl.module

class SpecialityBankApp : Application() {
    private val koinModule = module {
        val apiUrl = "apiUrl"
        single(named(apiUrl)) { BASE_API_URL }
        single(named("appScope")) { CoroutineScope(SupervisorJob()) }
        single { SpecialityWorkerDatabase.newInstance(androidContext()) }
        single { RetrofitBuilder.buildApi(get(named(apiUrl)))}

        factory { SaveToDbSpecialityWithWorkerRepositoryImpl(get()) } bind SaveToDbSpecialityWithWorkerRepository::class
        factory { GetByUrlSpecialityWithWorkerRepositoryImpl(get()) } bind GetByUrlSpecialityWithWorkerRepository::class
        factory { LoadFromDbRepositoryImpl(get()) } bind LoadFromDbRepository::class
        factory { ClearAllRepositoryImpl(get()) } bind ClearAllRepository::class

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

    override fun onCreate() {
        super.onCreate()

//        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.getDefaultNightMode())

        startKoin {
            androidLogger()
            androidContext(this@SpecialityBankApp)
            modules(koinModule)
        }
    }
}