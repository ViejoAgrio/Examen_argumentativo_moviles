package com.framework.views

import android.app.Activity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.data.network.model.CovidCases
import com.data.network.model.CovidDayDetails
import com.data.network.model.ModelCovid
import com.example.kotlin.argumentativo.R
import com.example.kotlin.argumentativo.databinding.ActivityMainBinding
import com.framework.adapters.CovidAdapter

class MainActivity : Activity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var covidAdapter: CovidAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initializeBinding()

        val covidCases = CovidCases()
        val covidDayDetailsList: List<CovidDayDetails> = covidCases.parseJson(this, "modelCovid.json")

        setupRecyclerView(covidDayDetailsList)
    }

    private fun setupRecyclerView(data: List<CovidDayDetails>) {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val covidAdapter = CovidAdapter(data) // Aquí aseguramos el tipo correcto
        recyclerView.adapter = covidAdapter
    }

    private fun initializeBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
