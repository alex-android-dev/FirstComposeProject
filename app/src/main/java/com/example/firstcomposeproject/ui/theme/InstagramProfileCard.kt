package com.example.firstcomposeproject.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.firstcomposeproject.R

@Preview
@Composable
fun InstagramHeadContainer() {
    val posts = "6.950"
    val followers = "436M"
    val following = "76"

    InstagramHead(posts, followers, following)
}

@Composable
fun InstagramHead(posts: String, followers: String, following: String) {
    val postsName = "Posts"
    val followersName = "Followers"
    val followingName = "Following"
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .fillMaxWidth(),
    ) {
        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier.size(50.dp),
                painter = painterResource(R.drawable.instagram_1_svgrepo_com),
                contentDescription = "App icon"
            )
        }
        InstagramTopColumn(posts, postsName)
        InstagramTopColumn(followers, followersName)
        InstagramTopColumn(following, followingName)
    }
}

@Composable
private fun InstagramTopColumn(value: String, description: String) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .border(width = 1.dp, Color.DarkGray),
        ) {
            Text(value)
        }

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .border(width = 1.dp, Color.DarkGray)
        ) {
            Text(description)
        }
    }

}