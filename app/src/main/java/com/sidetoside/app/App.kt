package com.sidetoside.app

import android.app.Application
import com.google.gson.Gson
import com.sidetoside.app.ui.util.Network
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class App : Application() {

    lateinit var retrofit: Retrofit

    override fun onCreate() {
        super.onCreate()

        val httpClient = OkHttpClient.Builder().apply {
            if (BuildConfig.BUILD_TYPE.toLowerCase().contains("debug"))
                addInterceptor(HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BASIC
                })
        }.build()

        retrofit = Retrofit.Builder()
            .baseUrl(Network.Domain + Network.Api)
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .build()

    }
}