package com.h5190036.h5190036_yunusemresamat_kotlinfinal.ui.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.h5190036.h5190036_yunusemresamat_kotlinfinal.data.repository.KullaniciRepository
import com.h5190036.h5190036_yunusemresamat_kotlinfinal.data.login.model.KullaniciModelItem
import com.h5190036.h5190036_yunusemresamat_kotlinfinal.util.ResourceStatus
import kotlinx.coroutines.launch

class KullaniciViewModel : ViewModel(){

    private  val kullaniciRepository: KullaniciRepository = KullaniciRepository()

    init {
        kullanicilariGetir()
    }

    var loading   : MutableLiveData<Boolean>? = MutableLiveData()
    var kullanicilarLiveData = MutableLiveData<List<KullaniciModelItem>>()
    var error =    MutableLiveData<Throwable>()

    fun kullanicilariGetir()  = viewModelScope.launch {

        kullaniciRepository.kullanicilariGetir()

            .asLiveData(viewModelScope.coroutineContext).observeForever {

                when(it.status) {
                    ResourceStatus.LOADING -> {
                        loading?.postValue(true)
                    }

                    ResourceStatus.SUCCESS -> {
                        kullanicilarLiveData.postValue(it.data!!)
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
