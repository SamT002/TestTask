package com.example.retrofit.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.retrofit.repository.MyRepository
import java.lang.IllegalArgumentException

class viewModelFactory:ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(mainViewModel::class.java)){
            return mainViewModel(MyRepository()) as T
        }
        throw IllegalArgumentException("Unknown class")
    }
}