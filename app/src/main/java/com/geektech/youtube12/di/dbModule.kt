package com.geektech.youtube12.di

import android.content.Context
import androidx.room.Room
import com.geektech.youtube12.data.local.AppDataBase
import org.koin.dsl.module

val dbModule= module {
    single { provideDb(get()) }
}
fun provideDb(applicationContext: Context):AppDataBase{
return Room.databaseBuilder(
    applicationContext,
    AppDataBase::class.java, "playlist.db"
).build()
}