package id.revan.mvpwithdagger.di

import dagger.Module
import dagger.Provides
import id.revan.mvpwithdagger.api.ApiInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class ApiModule {
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideApiInterface(retrofit: Retrofit): ApiInterface {
        return retrofit.create(ApiInterface::class.java)
    }
}