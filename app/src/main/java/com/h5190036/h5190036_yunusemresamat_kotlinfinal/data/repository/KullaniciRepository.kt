package com.h5190036.h5190036_yunusemresamat_kotlinfinal.data.repository

import com.h5190036.h5190036_yunusemresamat_kotlinfinal.data.KullaniciDataSource
import com.h5190036.h5190036_yunusemresamat_kotlinfinal.data.remote.KullaniciRetrofitDataSource
import com.h5190036.h5190036_yunusemresamat_kotlinfinal.data.login.model.KullaniciModel
import com.h5190036.h5190036_yunusemresamat_kotlinfinal.util.Resource
import kotlinx.coroutines.flow.Flow

class KullaniciRepository {

    private var kullaniciDataSource: KullaniciDataSource?=null

    init {
        kullaniciDataSource= KullaniciRetrofitDataSource()
    }

    fun kullanicilariGetir(): Flow<Resource<KullaniciModel>>
    {
        return kullaniciDataSource!!.kullanicilariGetir()
    }

}