package id.revan.mvpwithdagger.api

import id.revan.mvpwithdagger.model.Post
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("posts")
    fun getPosts(): Call<List<Post>>

    @GET("posts/{id}")
    fun getPost(@Path("id") id: String): Call<Post>
}