package com.example.tasbihcounter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tasbihcounter.ui.theme.TasbihCounterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TasbihCounterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TasbihCounterApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class) // Required for TopAppBar
@Composable
fun TasbihCounterApp() {
    // State to hold the current count, initialized to 0
    // `var count by remember { mutableIntStateOf(0) }` allows direct updates like `count++` and `count = 0`
    var count by remember { mutableIntStateOf(0) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Tasbih Counter") }
            )
        }
    ) { paddingValues ->
        // Content for the Tasbih counter screen
        Column(
            modifier = Modifier
                .padding(paddingValues) // Apply padding from Scaffold
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center, // Center items vertically
            horizontalAlignment = Alignment.CenterHorizontally // Center items horizontally
        ) {
            // Display the current count
            Text(
                text = "$count",
                fontSize = 96.sp, // Very large font size for prominence
                modifier = Modifier.padding(16.dp)
            )

            Spacer(modifier = Modifier.height(32.dp)) // Space between count and buttons

            // Button to increment the count (Tasbih button)
            Button(
                onClick = { count++ }, // Increment count on click
                modifier = Modifier
                    .fillMaxWidth(0.8f) // Button takes 80% of the screen width
                    .height(72.dp)       // Taller button for easier tapping
            ) {
                Text("سبحان الله", fontSize = 24.sp) // Arabic phrase "Subhan Allah"
            }

            Spacer(modifier = Modifier.height(16.dp)) // Space between buttons

            // Button to reset the count
            Button(
                onClick = { count = 0 }, // Reset count to 0 on click
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error), // Use error color for a distinct reset button
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .height(60.dp)
            ) {
                Text("Reset", fontSize = 20.sp)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TasbihCounterPreview() {
    TasbihCounterTheme {
        TasbihCounterApp()
    }
}