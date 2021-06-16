package com.h5190036.h5190036_yunusemresamat_kotlinfinal.data

import com.h5190036.h5190036_yunusemresamat_kotlinfinal.data.ilan.model.IlanModel
import com.h5190036.h5190036_yunusemresamat_kotlinfinal.util.Resource
import kotlinx.coroutines.flow.Flow

interface IlanDataSource {

    fun ilanlariGetir(): Flow<Resource<IlanModel>>

}