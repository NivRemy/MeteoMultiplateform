package org.example.project.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.example.project.model.WeatherBean
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun MyError(modifier: Modifier = Modifier, errorMessage:String?){
    AnimatedVisibility(
        visible = !errorMessage.isNullOrBlank(),
        modifier = modifier
            .background(MaterialTheme.colorScheme.error)
            .fillMaxWidth()
            .padding(5.dp)
    ){
        Text(errorMessage ?: "-",
            modifier = Modifier,
            color = MaterialTheme.colorScheme.onError)
    }
}

@Composable
expect fun WeatherGallery(modifier: Modifier, urlList: List<WeatherBean>, onPictureClick : (WeatherBean)->Unit)