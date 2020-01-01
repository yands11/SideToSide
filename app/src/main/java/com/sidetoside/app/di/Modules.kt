package com.sidetoside.app.di

import com.google.gson.Gson
import com.sidetoside.app.BuildConfig
import com.sidetoside.app.network.CompareAPI
import com.sidetoside.app.ui.home.HomeViewModel
import com.sidetoside.app.ui.util.Network
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val networkModule = module {

    single<String>(named("base_url")) {
        Network.Domain + Network.Api
    }

    single<HttpLoggingInterceptor> {
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BASIC
        }
    }

    single<OkHttpClient> {
        OkHttpClient.Builder().apply {
            if (BuildConfig.BUILD_TYPE.toLowerCase().contains("debug"))
                addInterceptor(get<HttpLoggingInterceptor>())
        }.build()
    }

    single<Gson> {
        Gson()
    }

    single<GsonConverterFactory> {
        GsonConverterFactory.create(get<Gson>())
    }

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(get<String>(named("base_url")))
            .client(get<OkHttpClient>())
            .addConverterFactory(get<GsonConverterFactory>())
            .build()
    }
}

val apiModule = module {

    single<CompareAPI> {
        get<Retrofit>().create(CompareAPI::class.java)
    }

}

val viewModelModule = module {

    viewModel { HomeViewModel(get<CompareAPI>()) }

}