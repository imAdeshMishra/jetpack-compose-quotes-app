package com.example.jetpackquotes

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.example.jetpackquotes.models.Quote
import com.google.gson.Gson

object DataManager {

    var data = emptyArray<Quote>()
    var isDataLoaded = mutableStateOf(false)

    fun  readAssetsFromFile(context : Context) {
        val inputStream = context.assets.open("quotes.json")
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)

        inputStream.read(buffer)
        inputStream.close()

        val json = String(buffer,Charsets.UTF_8)
        val gson= Gson()
        data = gson.fromJson(json,Array<Quote>::class.java)

        isDataLoaded.value = true
    }
}