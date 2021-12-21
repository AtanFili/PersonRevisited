package com.gsixacademy.android.personrevisited.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.gsixacademy.android.personrevisited.R
import com.gsixacademy.android.personrevisited.adapters.CastOnClickEvent
import com.gsixacademy.android.personrevisited.adapters.PeopleAdapter
import com.gsixacademy.android.personrevisited.api.ApiServiceBuilder
import com.gsixacademy.android.personrevisited.api.MoviesDatabaseApi
import com.gsixacademy.android.personrevisited.models.PeopleResponse
import kotlinx.android.synthetic.main.movies_list_fragment.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PeopleFragment : Fragment() {
    var peopleList = ArrayList<PeopleResponse>()
    var request = ApiServiceBuilder.buildService(MoviesDatabaseApi::class.java)
    lateinit var PeopleListAdapter: PeopleAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val view=inflater.inflate(R.layout.movies_list_fragment,container,false)
        val call = request.getPopularPerson()

        call.enqueue(object : Callback<PeopleResponse> {

            override fun onResponse(
                call: Call<PeopleResponse>,
                response: Response<PeopleResponse>
            ) {
                if (response.isSuccessful) {
                    val peopleRespose = response.body()
                    val peopleList = peopleRespose?.results


                    if (peopleList != null) {
                        val peopleListAdapter = PeopleAdapter(peopleList) {


                        }
                        recycler_view_movies.layoutManager = LinearLayoutManager(context)
                        recycler_view_movies.adapter = peopleListAdapter

                    }


                } else {}


            }


            override fun onFailure(call: Call<PeopleResponse>, t: Throwable) {
                Toast.makeText(activity,t.message, Toast.LENGTH_SHORT)
                    .show()
            }
                                                                                                                                              `
        })
        return view
    }


}



