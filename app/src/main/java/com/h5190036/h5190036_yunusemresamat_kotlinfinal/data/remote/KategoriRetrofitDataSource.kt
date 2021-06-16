package com.h5190036.h5190036_yunusemresamat_kotlinfinal.data.remote

import com.h5190036.h5190036_yunusemresamat_kotlinfinal.data.KategoriDataSource
import com.h5190036.h5190036_yunusemresamat_kotlinfinal.data.kategori.KategoriModel
import com.h5190036.h5190036_yunusemresamat_kotlinfinal.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class KategoriRetrofitDataSource: KategoriDataSource {

    override fun kategorileriGetir(): Flow<Resource<KategoriModel>> = flow {
        try {

            emit(Resource.Loading())

            val response = ApiService.build().kategorileriGetir()

            if (response.isSuccessful) {

                response.body()?.let {
                    emit(Resource.Success(it))
                }
            }

        } catch (e: Exception) {
            emit(Resource.Error(e))
            e.printStackTrace()
        }
    }

}