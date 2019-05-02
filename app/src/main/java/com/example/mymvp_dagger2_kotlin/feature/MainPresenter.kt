package com.example.mymvp_dagger2_kotlin.feature

import android.util.Log
import com.example.mymvp_dagger2_kotlin.util.Constants
import com.example.mymvp_dagger2_kotlin.endpoint.ApiService
import com.example.mymvp_dagger2_kotlin.model.NewsModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainPresenter: MainContract.Presenter {

    private lateinit var view: MainContract.View
    private val subscriptions = CompositeDisposable()
    private val api: ApiService = ApiService.create()

    override fun subscribe() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun unsubscribe() {
       subscriptions.clear()
    }

    override fun attach(view: MainContract.View) {
        this.view = view;
    }

    override fun loadData() {
        view.showProgress()
        subscriptions.add(
        api.getTopNews(
            Constants.SOURCE,
            Constants.API_KEY
        )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(this::handleResponse,this::handleError))
    }

    private fun handleResponse(newsData: NewsModel.Result) {
        view.DismissProgress()
        view.displayNewsData(newsData)
        Log.d("Success", newsData.toString())
    }

    private fun handleError(error: Throwable) {
        view.DismissProgress()
        Log.d("Error", error.localizedMessage)
    }

}