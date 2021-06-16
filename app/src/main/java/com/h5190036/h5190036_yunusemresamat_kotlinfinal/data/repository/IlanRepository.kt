package com.h5190036.h5190036_yunusemresamat_kotlinfinal.data.repository

import com.h5190036.h5190036_yunusemresamat_kotlinfinal.data.IlanDataSource
import com.h5190036.h5190036_yunusemresamat_kotlinfinal.data.ilan.model.IlanModel
import com.h5190036.h5190036_yunusemresamat_kotlinfinal.data.remote.IlanRetrofitDataSource
import com.h5190036.h5190036_yunusemresamat_kotlinfinal.util.Resource
import kotlinx.coroutines.flow.Flow

class IlanRepository {

    private var ilanDataSource: IlanDataSource?=null

    init {
        ilanDataSource= IlanRetrofitDataSource()
    }

    fun ilanlariGetir(): Flow<Resource<IlanModel>>
    {
        return ilanDataSource!!.ilanlariGetir()
    }

}