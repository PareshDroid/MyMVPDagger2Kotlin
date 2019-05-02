package com.example.mymvp_dagger2_kotlin.feature

import com.example.mymvp_dagger2_kotlin.model.NewsModel

class MainContract {

    interface Presenter: BaseContract.Presenter<View> {
        fun loadData() // Let's assume that this will be a retrofit request
    }

    interface View: BaseContract.View {
        fun showProgress()
        fun DismissProgress()
        fun displayNewsData(newsData: NewsModel.Result)
    }
}