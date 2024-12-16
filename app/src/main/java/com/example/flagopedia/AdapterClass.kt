package com.example.flagopedia

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterClass(
    private val countryList: ArrayList<DataClass>,
    private val context: Context
) : RecyclerView.Adapter<AdapterClass.CountryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.country_list, parent, false)
        return CountryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val country = countryList[position]

        holder.countryLogo.setImageResource(country.image)
        holder.countryName.text = country.name

        // Set click listener
        holder.itemView.setOnClickListener {
            // Toggle visibility of capital text
            if (holder.countryCapital.visibility == View.GONE) {
                holder.countryCapital.visibility = View.VISIBLE
                holder.countryCapital.text = country.capital
            } else {
                holder.countryCapital.visibility = View.GONE
            }
        }
    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    inner class CountryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val countryLogo: ImageView = view.findViewById(R.id.countryLogo)
        val countryName: TextView = view.findViewById(R.id.countryName)
        val countryCapital: TextView = view.findViewById(R.id.countryCapital)
    }
}
