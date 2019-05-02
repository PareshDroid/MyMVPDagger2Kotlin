package com.example.mymvp_dagger2_kotlin.model

object NewsModel {
    data class Result(val status: String, val totalResults:Int,val articles:ArrayList<Articles>)
    data class Articles(val author: String, val title:String,val description:String,val url:String,val urlToImage:String,val publishedAt:String,val content:String)

}