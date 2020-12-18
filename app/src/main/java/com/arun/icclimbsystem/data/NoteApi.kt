package com.arun.icclimbsystem.data

import com.arun.icclimbsystem.models.ClassNotes
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers

interface NoteApi {
    /*https://presencex.com/REVA/school/gettimetable*/
    @Headers(
//        "year:",
//        "class:",
        "section:A",
        "semester:3",
        "stream:str003",
        "request_date:03/12/2020",
        "api_key:da7b0a5b6396da422ef093ce1c59fc0ee8971406b480f02e2d64cf39f42b896e",
        "school_id:SCH10100"
    )
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