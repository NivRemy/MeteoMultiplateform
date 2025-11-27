package org.example.project.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.example.project.model.WeatherBean
import org.example.project.ui.screens.PictureRowItem

@Composable
actual fun WeatherGallery(
    modifier: Modifier,
    urlList: List<WeatherBean>,
    onPictureClick: (WeatherBean) -> Unit
) {
    LazyColumn(modifier = modifier){
        items(urlList.size) {
            PictureRowItem(Modifier, urlList[it], onPictureClick)
        }
    }
}