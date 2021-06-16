package com.h5190036.h5190036_yunusemresamat_kotlinfinal.ui.ilan

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.h5190036.h5190036_yunusemresamat_kotlinfinal.data.ilan.model.IlanModelItem
import com.h5190036.h5190036_yunusemresamat_kotlinfinal.data.repository.IlanRepository
import com.h5190036.h5190036_yunusemresamat_kotlinfinal.util.ResourceStatus
import kotlinx.coroutines.launch


class IlanViewModel : ViewModel() {

    private  val ilanRepository: IlanRepository = IlanRepository()

    init {
        ilanlariGetir()
    }

    var loading   : MutableLiveData<Boolean>? = MutableLiveData()
    var ilanLiveData = MutableLiveData<List<IlanModelItem>>()
    var error =    MutableLiveData<Throwable>()

    fun ilanlariGetir()  = viewModelScope.launch {

        ilanRepository.ilanlariGetir()

            .asLiveData(viewModelScope.coroutineContext).observeForever {

                when(it.status) {
                    ResourceStatus.LOADING -> {
                        loading?.postValue(true)
                    }

                    ResourceStatus.SUCCESS -> {
                        ilanLiveData.postValue(it.data!!)
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