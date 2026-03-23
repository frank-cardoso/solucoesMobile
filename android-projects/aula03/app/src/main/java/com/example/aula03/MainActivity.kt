package com.example.aula03

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.aula03.navigation.TreasureHuntNavGraph
import com.example.aula03.ui.theme.Aula03Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Aula03Theme {
                TreasureHuntNavGraph()
            }
        }
    }
}
