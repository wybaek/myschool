package com.wybaek.myschool.injection.module

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import com.wybaek.myschool.data.remote.RibotsService
import com.wybaek.myschool.data.remote.SchoolService
import javax.inject.Singleton

@Module
class ApiModule {

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                .create()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient()
    }

    @Provides
    @Singleton
    fun provideRibotsService(okHttpClient: OkHttpClient, gson: Gson): RibotsService {
        return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("https://api.ribot.io/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
                .create(RibotsService::class.java)
    }

    @Provides
    @Singleton
    fun provideSchoolService(okHttpClient: OkHttpClient, gson: Gson): SchoolService {
        return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("http://210.102.108.141/")
                .addConverterFactory(GsonConverterFactory.create(provideGson()))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
                .create(SchoolService::class.java)
    }

}
