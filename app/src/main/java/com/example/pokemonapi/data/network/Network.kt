package com.example.pokemonapi.data.network

import android.content.Context
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private const val TIME_OUT = 30L
fun createNetworkClient(baseUrl: String, debug: Boolean = false, context: Context): Retrofit =
    retrofitClient(baseUrl, httpClient(debug, context))

private fun httpClient(debug: Boolean, context: Context): OkHttpClient {
    val httpLoggingInterceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT)
    val clientBuilder = OkHttpClient.Builder()

    if (debug) {
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        clientBuilder.run {
            addInterceptor { chain ->
                val request = chain.request().newBuilder()
                chain.proceed(request.build())
            }

            addInterceptor(httpLoggingInterceptor)

        }
    }
    return clientBuilder.build()
}

private fun retrofitClient(baseUrl: String, httpClient: OkHttpClient) =
    Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(httpClient)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()



