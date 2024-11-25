package com.data

import android.content.Context
import com.data.network.model.CovidDayDetails
import com.data.network.model.ModelCovid
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class CovidCases {

    // Función para cargar el JSON desde la carpeta assets
    fun loadJsonFromAssets(context: Context, fileName: String): String {
        return context.assets.open(fileName).bufferedReader().use { it.readText() }
    }

    // Función para parsear el JSON a una lista de objetos ModelCovid
    fun parseJson(context: Context, fileName: String): List<CovidDayDetails> {
        val jsonString = loadJsonFromAssets(context, fileName)
        val gson = Gson()

        val listType = object : TypeToken<List<ModelCovid>>() {}.type
        val modelCovidList: List<ModelCovid> = gson.fromJson(jsonString, listType)

        // Transformar los datos en una lista plana
        val dayDetailsList = mutableListOf<CovidDayDetails>()
        modelCovidList.forEach { modelCovid ->
            modelCovid.cases.forEach { (date, caseDetails) ->
                dayDetailsList.add(
                    CovidDayDetails(
                        country = modelCovid.country,
                        date = date,
                        total = caseDetails.total,
                        new = caseDetails.new
                    )
                )
            }
        }

        return dayDetailsList
    }

}
