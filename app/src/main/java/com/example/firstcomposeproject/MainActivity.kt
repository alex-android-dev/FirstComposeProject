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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SwipeToDismiss
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun MainViewLazyColumn(viewModel: MainViewModel) {
    val models = viewModel.models.observeAsState(listOf())
    val lazyListState = rememberLazyListState()

    LazyColumn(
        modifier = Modifier.background(MaterialTheme.colorScheme.background),
        state = lazyListState,
    ) {

        items(
            items = models.value,
            key = { it.id },
        ) { model ->

            val dismissThresholds = with(receiver = LocalDensity.current) {
                LocalConfiguration.current.screenWidthDp.dp.toPx() * 0.80f
            } // свайпим на 80% и только тогда удаляется элемент

            val dismissState = rememberSwipeToDismissBoxState(
                positionalThreshold = { dismissThresholds },
                confirmValueChange = { value ->
                    val isDismissed = value in setOf(SwipeToDismissBoxValue.EndToStart)
                    if (isDismissed) viewModel.delete(model)
                    return@rememberSwipeToDismissBoxState true
                }
            ) // State для удаления свайпа


            SwipeToDismissBox(
                state = dismissState,
                enableDismissFromEndToStart = true,
                enableDismissFromStartToEnd = false,
                backgroundContent = {
                    Box(
                        modifier = Modifier
                            .padding(20.dp)
                            .background(Color.Red.copy())
                            .fillMaxSize(),
                        contentAlignment = Alignment.CenterEnd
                    ) {
                        Text(
                            modifier = Modifier.padding(16.dp),
                            text = "Delete Item",
                            color = Color.White, fontSize = 24.sp
                        )
                    }
                },
            )
            {
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
}