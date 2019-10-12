package id.revan.mvpwithdagger.di

import android.content.Context
import dagger.Module
import dagger.Provides
import id.revan.mvpwithdagger.helper.LayoutHelper

@Module
class UIModule(private val context: Context) {
    @Provides
    fun provideLayoutHelper(): LayoutHelper {
        return LayoutHelper(context)
    }
}