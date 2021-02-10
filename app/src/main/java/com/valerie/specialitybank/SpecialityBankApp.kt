package com.valerie.specialitybank

import android.app.Application
import com.valerie.specialitybank.di.dataModule
import com.valerie.specialitybank.di.domainModule
import com.valerie.specialitybank.di.presentationModule
import com.valerie.specialitybank.domain.usecase.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class SpecialityBankApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@SpecialityBankApp)
            modules(dataModule, domainModule, presentationModule)
        }
    }
}