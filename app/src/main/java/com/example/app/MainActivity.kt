package com.example.tasbihcounter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tasbihcounter.ui.theme.TasbihCounterTheme // নিশ্চিত করুন আপনার থিম ফাইলটি এই নামে আছে

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
                    TasbihCounterScreen()
                }
            }
        }
    }
}

@Composable
fun TasbihCounterScreen() {
    // বর্তমান গণনা সংরক্ষণের জন্য স্টেট ভেরিয়েবল।
    // rememberSaveable ব্যবহার করা হয়েছে যাতে স্ক্রিন রোটেট হলেও গণনা হারিয়ে না যায়।
    var count by rememberSaveable { mutableIntStateOf(0) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // গণনা প্রদর্শনের জন্য টেক্সট
        Text(
            text = "$count",
            fontSize = 96.sp, // বড় ফন্ট সাইজ
            modifier = Modifier.padding(16.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))

        // গণনার জন্য বাটন
        Button(
            onClick = { count++ },
            modifier = Modifier
                .fillMaxWidth(0.8f) // স্ক্রিনের ৮০% প্রস্থ
                .height(80.dp) // বাটনের উচ্চতা
        ) {
            Text("গণনা করুন", fontSize = 28.sp)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // রিসেট করার জন্য বাটন
        OutlinedButton( // আউটলাইন বাটন ব্যবহার করা হয়েছে যাতে "গণনা করুন" বাটন থেকে আলাদা দেখায়
            onClick = { count = 0 },
            modifier = Modifier
                .fillMaxWidth(0.6f) // স্ক্রিনের ৬০% প্রস্থ
                .height(60.dp)
        ) {
            Text("রিসেট করুন", fontSize = 20.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TasbihCounterPreview() {
    TasbihCounterTheme {
        TasbihCounterScreen()
    }
}