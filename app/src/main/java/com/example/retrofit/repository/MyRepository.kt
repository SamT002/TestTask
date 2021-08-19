package com.example.retrofit.repository

import com.example.retrofit.model.myModel
import com.example.retrofit.retrofit.RetrofitInstance
import retrofit2.Response

class MyRepository() {
    suspend fun getData(): Response<List<myModel>>{
        return RetrofitInstance.getInstance().getDataRequest()
    }


}