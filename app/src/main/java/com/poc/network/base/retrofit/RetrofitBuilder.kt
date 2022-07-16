package com.poc.network.base.retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    private const val API_URL = "https://api.themoviedb.org/3/"
    const val KEY = "141671642cb27ab3e1f4f58cf119fd6e"

    fun provideRetrofitBuild(): Retrofit {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
        return Retrofit.Builder()
            .client(client)
            .addConverterFactory(
                GsonConverterFactory.create()
            ).baseUrl(API_URL).build()
    }
}