package com.example.mymvp_dagger2_kotlin.di.component

import com.example.mymvp_dagger2_kotlin.feature.MainActivity
import com.example.mymvp_dagger2_kotlin.di.module.ActivityModule
import dagger.Component

@Component(modules = arrayOf(ActivityModule::class))
interface ActivityComponent {

    fun inject(mainActivity: MainActivity)

}