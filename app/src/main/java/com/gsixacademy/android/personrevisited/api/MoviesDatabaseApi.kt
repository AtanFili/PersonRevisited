package com.gsixacademy.android.personrevisited.api

import com.gsixacademy.android.personrevisited.models.PeopleResponse
import retrofit2.Call
import retrofit2.http.GET

interface MoviesDatabaseApi {
    @GET("person/popular?")
    fun getPopularPerson():Call<PeopleResponse>
}