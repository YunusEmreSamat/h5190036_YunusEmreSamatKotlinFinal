package com.h5190036.h5190036_yunusemresamat_kotlinfinal.data.remote

import com.h5190036.h5190036_yunusemresamat_kotlinfinal.data.KullaniciDataSource
import com.h5190036.h5190036_yunusemresamat_kotlinfinal.data.login.model.KullaniciModel
import com.h5190036.h5190036_yunusemresamat_kotlinfinal.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class KullaniciRetrofitDataSource : KullaniciDataSource {

    override fun kullanicilariGetir(): Flow<Resource<KullaniciModel>> = flow {
        try {

            emit(Resource.Loading())

            val response = ApiService.build().kullanicilariGetir()

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