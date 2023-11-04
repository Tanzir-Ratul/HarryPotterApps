package com.example.harrypotterapps.di

import com.example.harrypotterapps.api.RetrofitClint.instanceRetrofit
import com.example.harrypotterapps.api.ApiServiceHarry
import com.example.harrypotterapps.constantFile.Constant
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Named("apiHarry")
    fun supplyBaseURL() = Constant.baseURL.trim()

    @Provides
    @Singleton
    fun supplyRetrofitInstance(@Named("apiHarry") baseUrl: String, gson: Gson, httpClient: OkHttpClient): ApiServiceHarry =
        instanceRetrofit(baseUrl, gson, httpClient)
            .create(ApiServiceHarry::class.java)


}