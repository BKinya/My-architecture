package com.beatrice.myarchitecture.di

import com.beatrice.myarchitecture.MyRepository
import com.beatrice.myarchitecture.MyViewModel
import com.beatrice.myarchitecture.data.MyDatabase
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModules = module {
    single { MyDatabase.getInstance(get()) }
    factory {  (get() as MyDatabase).myDao()}
    factory { MyRepository(get()) }
    viewModel { MyViewModel(get()) }
}