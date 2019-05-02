package com.example.mymvp_dagger2_kotlin.di.module

import android.app.Activity
import com.example.mymvp_dagger2_kotlin.feature.MainActivity
import com.example.mymvp_dagger2_kotlin.feature.MainContract
import com.example.mymvp_dagger2_kotlin.feature.MainPresenter
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private var activity: Activity) {

    @Provides
    fun provideActivity(): Activity {
        return activity
    }

    @Provides
    fun provideMainPresenter(): MainContract.Presenter {
        return MainPresenter()
    }

    @Provides
    fun provideMainView(): MainContract.View {
        return MainActivity()
    }

}