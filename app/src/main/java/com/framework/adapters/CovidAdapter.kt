package com.framework.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.data.network.model.CovidDayDetails
import com.data.network.model.ModelCovid
import com.example.kotlin.argumentativo.R

class CovidAdapter(private val dataList: List<CovidDayDetails>) :
    RecyclerView.Adapter<CovidAdapter.CovidViewHolder>() {

    class CovidViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvCountry: TextView = view.findViewById(R.id.tvCountry)
        val tvDate: TextView = view.findViewById(R.id.tvDate)
        val tvCases: TextView = view.findViewById(R.id.tvCases)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CovidViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_covid_data, parent, false)
        return CovidViewHolder(view)
    }

    override fun onBindViewHolder(holder: CovidViewHolder, position: Int) {
        val details = dataList[position]
        holder.tvCountry.text = details.country
        holder.tvDate.text = "Date: ${details.date}"
        holder.tvCases.text = "Total: ${details.total} | New: ${details.new}"
    }

    override fun getItemCount(): Int = dataList.size
}


