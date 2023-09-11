package com.safonov.agriculturegis.api

import com.safonov.agriculturegis.data.models.FieldModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query

interface EgrnApi {
    @POST("search/cadastr")
    suspend fun searchObject(
        @Query("auth_token") authToken: String = TOKEN,
        @Body cadNum: String,
    ): FieldModel

    companion object {
        private const val BASE_URL = "https://reestr-api.ru/v1/"
        private const val TOKEN = "e3020e9c-fbef-4dd7-b9ec-c7648901d2aa"

        fun create(): EgrnApi {
            val logger = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(EgrnApi::class.java)
        }
    }
}