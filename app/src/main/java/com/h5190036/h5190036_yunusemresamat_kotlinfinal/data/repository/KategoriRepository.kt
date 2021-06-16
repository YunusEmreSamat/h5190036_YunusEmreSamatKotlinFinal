package com.h5190036.h5190036_yunusemresamat_kotlinfinal.data.repository

import com.h5190036.h5190036_yunusemresamat_kotlinfinal.data.KategoriDataSource
import com.h5190036.h5190036_yunusemresamat_kotlinfinal.data.kategori.KategoriModel
import com.h5190036.h5190036_yunusemresamat_kotlinfinal.data.remote.KategoriRetrofitDataSource
import com.h5190036.h5190036_yunusemresamat_kotlinfinal.util.Resource
import kotlinx.coroutines.flow.Flow

class KategoriRepository {

    private var kategoriDataSource: KategoriDataSource?=null

    init {
        kategoriDataSource= KategoriRetrofitDataSource()
    }

    fun kategorileriGetir(): Flow<Resource<KategoriModel>>
    {
        return kategoriDataSource!!.kategorileriGetir()
    }

}