package id.revan.mvpwithdagger.ui.main

import id.revan.mvpwithdagger.model.Post
import id.revan.mvpwithdagger.ui.base.View

interface MainView : View {
    fun onLoadPost()

    fun onSuccessLoadPost(posts: List<Post>)

    fun onFailedLoadPost(message: String)
}