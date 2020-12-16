package com.arun.icclimbsystem.data

import com.arun.icclimbsystem.models.ClassNotes
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface NoteApi {
    /*https://presencex.com/REVA/school/gettimetable*/
    @GET("gettimetable")
    fun getNotes(): Call<ClassNotes>

    companion object {
        private const val BASE_URL = "https://presencex.com/REVA/school/"
        operator fun invoke(): NoteApi {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(OkHttpClient.Builder().also {
                    val loggingInterceptor = HttpLoggingInterceptor().apply {
                        level = HttpLoggingInterceptor.Level.BODY
                    }
                    it.addInterceptor(loggingInterceptor)
                }.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(NoteApi::class.java)
        }
    }
}