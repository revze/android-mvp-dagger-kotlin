package id.revan.mvpwithdagger.di

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApiModule::class, UIModule::class])
interface AppComponent : AppGraph