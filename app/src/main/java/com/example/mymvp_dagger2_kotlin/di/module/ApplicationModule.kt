package com.example.mymvp_dagger2_kotlin.di.module

import android.app.Application
import com.example.mymvp_dagger2_kotlin.BaseApp
import com.example.mymvp_dagger2_kotlin.di.scope.PerApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val baseApp: BaseApp) {

    @Provides
    @Singleton
    @PerApplication
    fun provideApplication(): Application {
        return baseApp
    }
}