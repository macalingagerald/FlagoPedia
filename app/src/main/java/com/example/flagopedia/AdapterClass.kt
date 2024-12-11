package com.example.flagopedia

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterClass(val countryList : List<DataClass>, val context : Context) : RecyclerView.Adapter<AdapterClass.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val countryImage = view.findViewById<ImageView>(R.id.countryLogo)
        val countryName = view.findViewById<TextView>(R.id.countryName)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.country_list, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val module = countryList[position]

        holder.countryImage.setImageResource(module.countryImage)
        holder.countryName.text = module.countryName

        holder.countryName.setBackgroundResource(module.countryBackground)

    }
}