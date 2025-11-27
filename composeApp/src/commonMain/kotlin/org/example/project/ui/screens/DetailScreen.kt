package org.example.project.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil3.compose.AsyncImage
import meteomultiplateform.composeapp.generated.resources.Res
import meteomultiplateform.composeapp.generated.resources.back_btn
import meteomultiplateform.composeapp.generated.resources.load_data_btn
import org.example.project.model.WeatherBean
import org.example.project.viewmodel.MainViewModel
import org.jetbrains.compose.resources.stringResource

@Composable
fun DetailScreen(weatherBean: WeatherBean,
                 modifier: Modifier = Modifier,
                 onBackButtonClick: ()->Unit = {}
) {
    Scaffold {
        Column(
            modifier = modifier.fillMaxWidth().padding(it),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(weatherBean.name)
            Row(
                modifier = modifier
                    .padding(5.dp)
                    .background(Color.Blue)
                    .fillMaxWidth()
            ) {
                AsyncImage(
                    model = weatherBean.weather.first().icon,
                    //Pour aller le chercher dans string.xml R de votre package com.nom.projet
                    //contentDescription = getString(R.string.picture_of_cat),
                    //En dur
                    contentDescription = "Icone de la ville",
                    contentScale = ContentScale.FillWidth,
                    //placeholder = painterResource(R.mipmap.ic_launcher),
                    //error = painterResource(R.mipmap.ic_launcher),
                    onError = { println(it) },
                    modifier = Modifier
                        .heightIn(max = 100.dp)
                        .widthIn(max = 100.dp)
                )
            }
            Text(weatherBean.getResume())
            Button(
                onClick = { onBackButtonClick() },
                contentPadding = ButtonDefaults.ButtonWithIconContentPadding,

                ) {
                Icon(
                    Icons.Filled.PlayArrow,
                    contentDescription = "Back button",
                    modifier = Modifier.size(ButtonDefaults.IconSize)
                )
                Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                Text(stringResource(Res.string.back_btn))
            }
        }
    }
}