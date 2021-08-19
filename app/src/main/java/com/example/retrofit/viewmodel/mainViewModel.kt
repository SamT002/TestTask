package com.example.retrofit.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit.model.myModel
import com.example.retrofit.repository.MyRepository
import kotlinx.coroutines.launch


class mainViewModel(private val repository: MyRepository):ViewModel() {

    val data:MutableLiveData<List<myModel>> = MutableLiveData()

    init {
        getDataViewModel()
    }

    fun getDataViewModel(){
        viewModelScope.launch {
            val response = repository.getData()
            if(response.isSuccessful){
                data.postValue(response.body())
            }
        }
    }
}