package com.h5190036.h5190036_yunusemresamat_kotlinfinal.data.remote


import com.h5190036.h5190036_yunusemresamat_kotlinfinal.data.IlanDataSource
import com.h5190036.h5190036_yunusemresamat_kotlinfinal.data.ilan.model.IlanModel
import com.h5190036.h5190036_yunusemresamat_kotlinfinal.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class IlanRetrofitDataSource: IlanDataSource {

    override fun ilanlariGetir(): Flow<Resource<IlanModel>> = flow {
        try {

            emit(Resource.Loading())

            val response = ApiService.build().ilanlariGetir()

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