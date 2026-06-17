package com.example.tasbihapp

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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tasbihapp.ui.theme.TasbihAppTheme // নিশ্চিত করুন আপনার থিম ফাইলটি এখানে আছে

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TasbihAppTheme { // আপনার অ্যাপের থিম প্রয়োগ করুন
                TasbihCounterApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class) // TopAppBar ব্যবহারের জন্য এটি প্রয়োজন
@Composable
fun TasbihCounterApp() {
    // Tasbih গণনার সংখ্যাটি সংরক্ষণের জন্য একটি State,
    // যা স্ক্রিন ঘোরানো বা অ্যাপ বন্ধ হলেও মান মনে রাখবে।
    var count by rememberSaveable { mutableIntStateOf(0) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("তাসবিহ গণনাকারী") }
            )
        },
        content = { paddingValues ->
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues), // Scaffold থেকে আসা প্যাডিং প্রয়োগ করুন
                color = MaterialTheme.colorScheme.background
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Center, // উপাদানগুলো উল্লম্বভাবে কেন্দ্রে রাখুন
                    horizontalAlignment = Alignment.CenterHorizontally // উপাদানগুলো অনুভূমিকভাবে কেন্দ্রে রাখুন
                ) {
                    // বর্তমান গণনা সংখ্যা প্রদর্শন
                    Text(
                        text = "$count",
                        fontSize = 96.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )

                    Spacer(modifier = Modifier.height(32.dp))

                    // গণনার সংখ্যা বাড়ানোর জন্য বোতাম
                    Button(
                        onClick = { count++ },
                        modifier = Modifier
                            .fillMaxWidth(0.8f) // প্রস্থের 80% ব্যবহার করুন
                            .height(120.dp), // বোতামের উচ্চতা নির্ধারণ করুন
                        shape = MaterialTheme.shapes.extraLarge, // গোলাকার কোণ
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.primary // প্রাইমারি রঙ ব্যবহার করুন
                        )
                    ) {
                        Text(
                            text = "গণনা করুন", // অথবা "ট্যাপ করুন"
                            fontSize = 36.sp,
                            color = MaterialTheme.colorScheme.onPrimary // প্রাইমারি রঙের উপর টেক্সট রঙ
                        )
                    }

                    Spacer(modifier = Modifier.height(32.dp))

                    // গণনার সংখ্যা শূন্যতে পুনরায় সেট করার জন্য বোতাম
                    OutlinedButton(
                        onClick = { count = 0 },
                        modifier = Modifier
                            .fillMaxWidth(0.5f) // প্রস্থের 50% ব্যবহার করুন
                            .height(60.dp), // বোতামের উচ্চতা নির্ধারণ করুন
                        shape = MaterialTheme.shapes.medium // ডিফল্ট বা মাঝারি গোলাকার কোণ
                    ) {
                        Icon(
                            imageVector = Icons.Default.Refresh, // রিফ্রেশ আইকন
                            contentDescription = "পুনরায় শুরু করুন",
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text = "পুনরায় শুরু করুন", fontSize = 18.sp)
                    }
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun TasbihCounterAppPreview() {
    TasbihAppTheme {
        TasbihCounterApp()
    }
}