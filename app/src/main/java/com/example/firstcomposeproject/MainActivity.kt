package com.example.firstcomposeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.firstcomposeproject.ui.theme.FirstComposeProjectTheme
import com.example.firstcomposeproject.ui.theme.InstagramHeadContainer

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            FirstComposeProjectTheme {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background)
                    // Чтобы весь экран настраивал тот цвет, который соответствует теме
                ) {

                }
                InstagramHeadContainer()
            }
        }
    }
}

@Preview
@Composable
fun TestImage() {
    Image(
        modifier = Modifier
            .fillMaxSize() // Заполнить все пространство
            .clip(CircleShape), // Обрезать по форме (В данном случае это шейп)
        painter = painterResource(R.drawable.ic_launcher_background),
        contentDescription = "",
        contentScale = ContentScale.FillHeight // Растягивается по высоте или горизонту или во все стороны
    )
}
