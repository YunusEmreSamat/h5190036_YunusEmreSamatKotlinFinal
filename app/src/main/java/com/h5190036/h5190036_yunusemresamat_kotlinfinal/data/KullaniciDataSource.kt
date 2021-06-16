package com.h5190036.h5190036_yunusemresamat_kotlinfinal.data

import com.h5190036.h5190036_yunusemresamat_kotlinfinal.data.login.model.KullaniciModel
import com.h5190036.h5190036_yunusemresamat_kotlinfinal.util.Resource
import kotlinx.coroutines.flow.Flow

interface KullaniciDataSource {

    fun kullanicilariGetir(): Flow<Resource<KullaniciModel>>

}