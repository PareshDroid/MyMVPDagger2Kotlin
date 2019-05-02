package com.example.mymvp_dagger2_kotlin.feature

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toast
import com.example.mymvp_dagger2_kotlin.R
import com.example.mymvp_dagger2_kotlin.di.component.DaggerActivityComponent
import com.example.mymvp_dagger2_kotlin.di.module.ActivityModule
import com.example.mymvp_dagger2_kotlin.model.NewsModel
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainContract.View, ArticleAdapter.Listener {

    @Inject
    lateinit var presenter: MainContract.Presenter
    private var articleArrayList: ArrayList<NewsModel.Articles>? = null
    private var myAdapter: ArticleAdapter? = null

    override fun showProgress() {
        progressBar.visibility = View.VISIBLE
    }

    override fun DismissProgress() {
        progressBar.visibility = View.GONE
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        injectDependency()
        initRecyclerView()
        presenter.attach(this)
        presenter.loadData()
    }

    private fun initRecyclerView() {
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        article_recyclerView.layoutManager = layoutManager
    }


    private fun injectDependency() {
        val activityComponent = DaggerActivityComponent.builder()
            .activityModule(ActivityModule(this))
            .build()

        activityComponent.inject(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.unsubscribe()
    }

    override fun displayNewsData(newsData: NewsModel.Result) {
        articleArrayList = newsData.articles
        myAdapter = ArticleAdapter(articleArrayList!!, this)
        article_recyclerView.adapter = myAdapter
    }

    override fun onItemClick(retroCrypto: NewsModel.Articles) {
        Toast.makeText(this, "You clicked: ${retroCrypto.author}", Toast.LENGTH_LONG).show()
    }


}
