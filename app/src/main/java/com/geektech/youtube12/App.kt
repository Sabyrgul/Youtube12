package com.geektech.youtube12

import android.app.Application
import androidx.room.Room
import com.geektech.youtube12.data.local.AppDataBase
import com.geektech.youtube12.di.dbModule
import com.geektech.youtube12.di.networkModule
import com.geektech.youtube12.di.repoModule
import com.geektech.youtube12.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App:Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(listOf(networkModule, viewModelModule, repoModule, dbModule))
        }
    }
}