package id.revan.mvpwithdagger

import android.app.Application
import id.revan.mvpwithdagger.di.AppGraph
import id.revan.mvpwithdagger.di.Injector

class App : Application() {
    lateinit var injector: AppGraph

    companion object {
        private lateinit var app: App

        fun get(): App = app
    }

    override fun onCreate() {
        super.onCreate()

        app = this
        injector = Injector.create(this)
    }
}