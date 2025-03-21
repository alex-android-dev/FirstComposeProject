package com.example.firstcomposeproject

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import com.example.firstcomposeproject.ui.theme.FirstComposeProjectTheme
import com.example.firstcomposeproject.ui.theme.InstagramHeadContainer

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            FirstComposeProjectTheme {
                MainViewLazyColumn(viewModel)
            }
        }
    }


}

@Composable
private fun MainViewLazyColumn(viewModel: MainViewModel) {
    val models = viewModel.models.observeAsState(listOf())

    LazyColumn (
        modifier = Modifier.background(MaterialTheme.colorScheme.background),
    ) {

        items(models.value.size) { index ->
            val model = models.value[index]

            InstagramHeadContainer(
                instagramModel = model,
                onFollowClickListener = {
                    Log.d("MainActivity", "onFollowClickListener")
                    viewModel.changeFollowingStatus(model)
                }
            )

        }
    }
}