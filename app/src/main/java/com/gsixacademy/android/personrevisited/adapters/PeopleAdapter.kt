package com.gsixacademy.android.personrevisited.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gsixacademy.android.personrevisited.R
import com.gsixacademy.android.personrevisited.models.CastModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.cast_list_item.view.*

class PeopleAdapter(
    val peopleList: ArrayList<CastModel>,
    val peopleClickEvent: (CastOnClickEvent) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
   return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.cast_list_item,parent,false))


    }

    override fun getItemCount(): Int {
        return peopleList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val myViewHolder = holder as MyViewHolder
        myViewHolder.bindData(peopleList[position], position)

    }

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindData(itemModel: CastModel, position: Int) {
            itemView.item_number.visibility = View.VISIBLE
            itemView.cast_name_text_view.text = itemModel.name
            itemView.character_text_view.visibility = View.GONE
            Picasso.get().load("\"http://image.tmdb.org/t/p/w185\"" + itemModel.profile_path)
                .centerInside().resize(itemView.cast_photo.width, 150).placeholder(
                R.drawable.no_image
            ).into(itemView.cast_photo)
            itemView.item_number.text = (position + 1).toString()
            itemView.cast_main_layout.setOnClickListener {
                peopleClickEvent.invoke(CastOnClickEvent.onCastClickEvet(itemModel))
            }


        }


    }


}




