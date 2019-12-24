package com.sidetoside.app.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sidetoside.app.entity.Compare
import com.sidetoside.app.network.CompareAPI
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private lateinit var compareAPI: CompareAPI
    private val _compares = MutableLiveData<List<Compare>>()

    val bundle = object : LiveBundle {
        override val compares: LiveData<List<Compare>> = _compares
    }

    fun setup(compareAPI: CompareAPI) {
        this.compareAPI = compareAPI
        viewModelScope.launch {
            _compares.postValue(compareAPI.getCompares().body())
        }
    }

    interface LiveBundle {
        val compares: LiveData<List<Compare>>
    }
}