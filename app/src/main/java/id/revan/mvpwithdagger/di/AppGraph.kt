package id.revan.mvpwithdagger.di

import id.revan.mvpwithdagger.ui.main.MainActivity
import id.revan.mvpwithdagger.ui.postdetail.PostDetailActivity

interface AppGraph {
    fun inject(activity: MainActivity)

    fun inject(activity: PostDetailActivity)
}