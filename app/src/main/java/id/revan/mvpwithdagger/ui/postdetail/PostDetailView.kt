package id.revan.mvpwithdagger.ui.postdetail

import id.revan.mvpwithdagger.model.Post
import id.revan.mvpwithdagger.ui.base.View

interface PostDetailView : View {
    fun onLoadPost()

    fun onSuccessLoadPost(post: Post)

    fun onFailedLoadPost(message: String)
}