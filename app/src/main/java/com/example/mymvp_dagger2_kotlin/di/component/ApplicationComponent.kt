package com.example.mymvp_dagger2_kotlin.di.component

import com.example.mymvp_dagger2_kotlin.BaseApp
import com.example.mymvp_dagger2_kotlin.di.module.ApplicationModule
import dagger.Component

@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {

    fun inject(application: BaseApp)

}