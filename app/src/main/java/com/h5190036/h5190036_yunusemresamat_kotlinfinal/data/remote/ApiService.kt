package com.h5190036.h5190036_yunusemresamat_kotlinfinal.data.remote

import com.h5190036.h5190036_yunusemresamat_kotlinfinal.data.ilan.model.IlanModel
import com.h5190036.h5190036_yunusemresamat_kotlinfinal.data.kategori.KategoriModel
import com.h5190036.h5190036_yunusemresamat_kotlinfinal.data.login.model.KullaniciModel
import com.h5190036.h5190036_yunusemresamat_kotlinfinal.util.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {

    //https://raw.githubusercontent.com/YunusEmreSamat/h5190036_YunusEmreSamatKotlinFinal/main/Dokuman/jsondosyalari/
    @GET("Users.json")
    suspend fun kullanicilariGetir(): Response<KullaniciModel>

    @GET("Kategori.json")
    suspend fun kategorileriGetir(): Response<KategoriModel>

    @GET("Ilanlar.json")
    suspend fun ilanlariGetir(): Response<IlanModel>

    companion object  {

        fun build(): ApiService {

            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY

            val okHtppClient =  OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build()

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.BASE_URL)
                .client(okHtppClient)
                .build()

            return retrofit.create(ApiService::class.java)
        }
    }

}