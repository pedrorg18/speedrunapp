package com.pedroroig.speedrunapp.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory


class RetrofitManager {

    private fun getOkHttpclient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build()
    }

    private fun getRetrofit(): Retrofit =
            Retrofit.Builder()
                    .baseUrl(BACKEND_URL)
                    .client(getOkHttpclient())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()

    fun getGamesListService(): GamesListService =
        getRetrofit().create(GamesListService::class.java)

}