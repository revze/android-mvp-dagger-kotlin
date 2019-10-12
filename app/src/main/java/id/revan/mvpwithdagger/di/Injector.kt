package id.revan.mvpwithdagger.di

import android.content.Context
import id.revan.mvpwithdagger.App

class Injector {
    companion object {
        fun create(context: Context): AppGraph =
            DaggerAppComponent.builder().uIModule(UIModule(context)).build()

        fun obtain(): AppGraph = App.get().injector
    }
}