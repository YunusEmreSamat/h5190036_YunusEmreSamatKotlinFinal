package com.h5190036.h5190036_yunusemresamat_kotlinfinal.data

import com.h5190036.h5190036_yunusemresamat_kotlinfinal.data.kategori.KategoriModel
import com.h5190036.h5190036_yunusemresamat_kotlinfinal.util.Resource
import kotlinx.coroutines.flow.Flow

interface KategoriDataSource {

    fun kategorileriGetir(): Flow<Resource<KategoriModel>>

}