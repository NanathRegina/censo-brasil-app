package com.censobrasilapp.viewmodel

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.*
import com.censobrasilapp.api.PesquisaApi
import com.censobrasilapp.model.Pesquisa
import kotlinx.coroutines.launch

class PesquisaViewModel() : ViewModel() {
    private val _response = MutableLiveData<String>()
    val response: LiveData<String>
        get() = _response

    private var _pesquisa = MutableLiveData<Pesquisa>()
    val pesquisa: LiveData<Pesquisa>
        get() = _pesquisa

    init {
        getPesquisas()
    }

    private fun getPesquisas() {
        viewModelScope.launch {
            try {
                val result =
                    PesquisaApi.retrofitService.getPesquisas()
                _pesquisa.value = result

                _response.value = "Success!!!"
            } catch (e: Exception) {
                _response.value = "Failure: ${e.message}"
                Log.i("VM", e.toString())
            }
        }
    }


}


