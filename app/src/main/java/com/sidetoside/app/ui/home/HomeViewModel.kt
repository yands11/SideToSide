package com.sidetoside.app.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sidetoside.app.entity.Compare
import com.sidetoside.app.network.CompareAPI
import com.sidetoside.app.ui.Event
import com.sidetoside.app.ui.setEvent
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private lateinit var compareAPI: CompareAPI
    private val _compares = MutableLiveData<List<Compare>>()
    private val _clickAddEvent = MutableLiveData<Event<Unit>>()

    fun setup(compareAPI: CompareAPI) {
        this.compareAPI = compareAPI
        viewModelScope.launch {
            _compares.postValue(compareAPI.getCompares().body())
        }
    }

    val trigger = object : Trigger {
        override fun clickAdd() {
            _clickAddEvent.setEvent(Unit)
        }
    }
    val bundle = object : LiveBundle {
        override val compares: LiveData<List<Compare>> = _compares
        override val clickAddEvent: LiveData<Event<Unit>> = _clickAddEvent
    }

    interface LiveBundle {
        val compares: LiveData<List<Compare>>
        val clickAddEvent: LiveData<Event<Unit>>
    }

    interface Trigger {
        fun clickAdd()
    }
}