package com.h5190036.h5190036_yunusemresamat_kotlinfinal.ui.kategori

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.h5190036.h5190036_yunusemresamat_kotlinfinal.data.kategori.KategoriModelItem
import com.h5190036.h5190036_yunusemresamat_kotlinfinal.data.repository.KategoriRepository
import com.h5190036.h5190036_yunusemresamat_kotlinfinal.util.ResourceStatus
import kotlinx.coroutines.launch


class KategoriViewModel : ViewModel() {

    private  val kategoriRepository: KategoriRepository = KategoriRepository()

    init {
        kategorileriGetir()
    }

    var loading   : MutableLiveData<Boolean>? = MutableLiveData()
    var kategorilerLiveData = MutableLiveData<List<KategoriModelItem>>()
    var error =    MutableLiveData<Throwable>()

    fun kategorileriGetir()  = viewModelScope.launch {

        kategoriRepository.kategorileriGetir()

            .asLiveData(viewModelScope.coroutineContext).observeForever {

                when(it.status) {
                    ResourceStatus.LOADING -> {
                        loading?.postValue(true)
                    }

                    ResourceStatus.SUCCESS -> {
                        kategorilerLiveData.postValue(it.data!!)
                        loading?.postValue(false)
                    }

                    ResourceStatus.ERROR -> {
                        error.postValue(it.throwable!!)
                        loading?.postValue(false)
                    }
                }
            }
    }

}