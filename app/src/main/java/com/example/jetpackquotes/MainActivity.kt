package com.example.jetpackquotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.example.jetpackquotes.screens.QuoteDetail
import com.example.jetpackquotes.screens.QuoteListScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DataManager.readAssetsFromFile(this)

        setContent {
            App()
        }
    }
}

@Composable
fun App() {
    if (DataManager.isDataLoaded.value){
        QuoteListScreen(data = DataManager.data) {
            
        }
    }
}