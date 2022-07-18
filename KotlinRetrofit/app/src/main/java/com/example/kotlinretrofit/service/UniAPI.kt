package com.example.kotlinretrofit.service

import com.example.kotlinretrofit.model.University
import retrofit2.http.GET
import retrofit2.Call

interface UniAPI {

//https://raw.githubusercontent.com/
// Hipo/university-domains-list/master/world_universities_and_domains.json
//https://dog.ceo/api/breeds/image/random


    @GET("Hipo/university-domains-list/master/world_universities_and_domains.json")
    fun getData() : Call<List<University>>


}

