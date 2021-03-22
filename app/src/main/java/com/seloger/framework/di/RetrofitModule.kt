package com.seloger.framework.di

import com.google.gson.GsonBuilder
import com.seloger.framework.gataway.retrofit.Api
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class RetrofitModule {

    @Provides
    @Singleton
    fun getApi(): Api {
        val httpClient = OkHttpClient.Builder()
        val retrofitInstance = Retrofit.Builder().baseUrl(Api.URL)
            .client(httpClient.build())
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
            .build()

        return retrofitInstance.create(Api::class.java)
    }
}