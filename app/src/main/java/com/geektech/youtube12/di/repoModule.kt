package com.geektech.youtube12.di

import com.geektech.youtube12.data.Repository
import org.koin.dsl.module

val repoModule= module {
    single { Repository(get(),get()) }
}