package com.example.firstcomposeproject.ui.theme

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firstcomposeproject.R
import java.nio.file.WatchEvent

const val postsName = "Posts"
const val followersName = "Followers"
const val followingName = "Following"
const val instagramName = "Instagram"
const val hashtagName = "#YoursToMake"
const val urlName = "www.facebook.com/emotional_health"
const val followAction = "Follow"

@Composable
fun InstagramHeadContainer() {
    val posts = "6.950"
    val followers = "436M"
    val following = "76"

    InstagramCard(posts, followers, following)
}

@Composable
fun InstagramCard(posts: String, followers: String, following: String) {

    Card(
        modifier = Modifier.padding(
            horizontal = 8.dp,
            vertical = 20.dp
        ),
        shape = RoundedCornerShape(
            topStart = 4.dp,
            topEnd = 4.dp,
        ),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.onBackground),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background,
            contentColor = MaterialTheme.colorScheme.onBackground,
        )
    ) {
        UserStatistics(posts, followers, following)
    }
}


@Composable
fun UserStatistics(posts: String, followers: String, following: String) {
    val postsName = "Posts"
    val followersName = "Followers"
    val followingName = "Following"
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .fillMaxWidth(),
    ) {
        InstagramLogo()
        InstagramTopColumn(posts, postsName)
        InstagramTopColumn(followers, followersName)
        InstagramTopColumn(following, followingName)
    }
    Column(
        modifier = Modifier.padding(start = 10.dp)
    ) {
        Text(
            fontFamily = FontFamily.Cursive,
            fontSize = 30.sp,
            text = instagramName,
        )

        Text(
            modifier = Modifier.height(20.dp),
            fontSize = 10.sp,
            text = hashtagName,
        )

        Text(
            modifier = Modifier.height(20.dp),
            fontSize = 10.sp,
            text = urlName,
        )

        Button(
            modifier = Modifier
                .padding(bottom = 10.dp)
                .height(24.dp),
            onClick = { },
            shape = RoundedCornerShape(5.dp),
            contentPadding = PaddingValues(0.dp),
        ) {
            Text(
                fontSize = 10.sp,
                text = followAction,
            )
        }

    }
}

@Composable
private fun InstagramLogo() {
    Image(
        modifier = Modifier
            .size(50.dp)
            .clip(CircleShape)
            .background(Color.White)
            .padding(5.dp),
        painter = painterResource(R.drawable.instagram_1_svgrepo_com),
        contentDescription = "App icon",
    )
}

@Composable
private fun InstagramTopColumn(value: String, title: String) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = value,
            fontSize = 32.sp,
            fontFamily = FontFamily.Cursive
        )

        Text(
            text = title,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
        )

    }

}

@Preview
@Composable
fun PreviewCardLight() {
    FirstComposeProjectTheme(
        darkTheme = false
    ) {
        InstagramHeadContainer()
    }
}

@Preview
@Composable
fun PreviewCardDark() {
    FirstComposeProjectTheme(
        darkTheme = true
    ) {
        InstagramHeadContainer()
    }
}

