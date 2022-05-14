package com.tech.phantoms.healthier.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import com.tech.phantoms.healthier.R
import com.tech.phantoms.healthier.ui.composables.TopBar
import com.tech.phantoms.healthier.ui.theme.HBlack
import com.tech.phantoms.healthier.ui.theme.HealthierTheme

class HomeUserActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_Healthier)

        setContent {
            HomeUserScreenContent {
                Scaffold(
                    backgroundColor = MaterialTheme.colors.HBlack,
                    topBar = { TopBar() },
                    content = {},
                    bottomBar = {}
                )
            }
        }
    }
}

@Composable
fun HomeUserScreenContent(content: @Composable () -> Unit){
    HealthierTheme {
        Surface(color = MaterialTheme.colors.HBlack) {
            content()
        }
    }
}