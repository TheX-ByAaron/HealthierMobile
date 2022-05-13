package com.tech.phantoms.healthier

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.tech.phantoms.healthier.ui.theme.HBlack
import com.tech.phantoms.healthier.ui.theme.HealthierTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_Healthier)
        setContent {
            MainActivityScreenContent {
                MainScreen()
            }
        }
    }
}


@Composable
fun MainActivityScreenContent(content: @Composable () -> Unit){
    HealthierTheme {
        Surface(color = MaterialTheme.colors.HBlack) {
            content()
        }
    }
}

@Composable
fun MainScreen(){
    Column(modifier = Modifier.fillMaxSize()) {
        Image(painter = painterResource(id = R.drawable.ic_logo_stripped)
            , contentDescription = "main logo")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HealthierTheme {
        MainScreen()
    }
}