package org.example.project.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key.Companion.R
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import coil3.compose.AsyncImage
import meteomultiplateform.composeapp.generated.resources.Res
import meteomultiplateform.composeapp.generated.resources.clear_btn
import meteomultiplateform.composeapp.generated.resources.load_data_btn
import org.example.project.model.WeatherBean
import org.example.project.ui.MyError
import org.example.project.ui.WeatherGallery
import org.example.project.viewmodel.MainViewModel
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun SearchScreen(
    modifier: Modifier = Modifier,
    mainViewModel: MainViewModel,
    onPictureClick : (WeatherBean)->Unit = {}
) {
    Column (modifier = modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        var searchText by rememberSaveable { mutableStateOf("") } //va dans le viewmodel
        val list by mainViewModel.dataList.collectAsStateWithLifecycle()
        var errorMessage = mainViewModel.errorMessage.collectAsStateWithLifecycle().value
        MyError(errorMessage = errorMessage)
        SearchBar(
            searchText = searchText,
            onSearchKeyboard = { mainViewModel.loadWeathers(searchText) },
            onValueChange  = { searchText = it }
        )
        AnimatedVisibility(visible = mainViewModel.runInProgress.collectAsStateWithLifecycle().value){
            CircularProgressIndicator()
        }

        WeatherGallery(modifier = Modifier.weight(1f), list, onPictureClick)
        /*LazyColumn(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            items(list.size) {
                PictureRowItem(Modifier, list[it], onPictureClick)
            }
        }*/
        Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
            Button(
                onClick = { searchText = "" },
                contentPadding = ButtonDefaults.ButtonWithIconContentPadding,

                ) {
                Icon(
                    Icons.Filled.Clear,
                    contentDescription = "Localized description",
                    modifier = Modifier.size(ButtonDefaults.IconSize)
                )
                Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                Text(stringResource(Res.string.clear_btn))
            }
            Button(
                onClick = { mainViewModel.loadWeathers(searchText) },
                contentPadding = ButtonDefaults.ButtonWithIconContentPadding,

            ) {
                Icon(
                    Icons.Filled.PlayArrow,
                    contentDescription = "Localized description",
                    modifier = Modifier.size(ButtonDefaults.IconSize)
                )
                Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                Text(stringResource(Res.string.load_data_btn))
            }
        }

    }
}

@Composable
fun SearchBar(modifier: Modifier = Modifier, searchText: String,onSearchKeyboard: () -> Unit, onValueChange: (String) -> Unit){
    TextField(
        value = searchText, //Valeur affichée
        onValueChange = onValueChange,
        leadingIcon = { //Image d'icône
            Icon(
                imageVector = Icons.Default.Search,
                tint = MaterialTheme.colorScheme.primary,
                contentDescription = null
            )
        },
        singleLine = true,
        label = { //Texte d'aide qui se déplace
            Text("Enter text")
            //Pour aller le chercher dans string.xml, R de votre package com.nom.projet
            //Text(stringResource(R.string.placeholder_search))
        },
        //placeholder = { //Texte d'aide qui disparait
        //Text("Recherche")
        //},

        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search), // Définir le bouton "Entrée" comme action de recherche
        keyboardActions = KeyboardActions(onSearch = {onSearchKeyboard()}), // Déclenche l'action définie
        //Comment le composant doit se placer
        modifier = modifier
            .fillMaxWidth() // Prend toute la largeur
            .heightIn(min = 56.dp) //Hauteur minimum
    )
}

@Composable
fun PictureRowItem(modifier: Modifier = Modifier ,weatherBean: WeatherBean, onPictureClick : (WeatherBean)->Unit) {
    var displayText by remember { mutableStateOf(false) }
    Row (modifier = modifier
        .padding(5.dp)
        .background(Color.Blue)
        .fillMaxWidth()) {
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
                .clickable(onClick = {onPictureClick(weatherBean)})
                .heightIn(max = 100.dp)
                .widthIn(max = 100.dp)
        )
        Column (modifier = Modifier.background(MaterialTheme.colorScheme.tertiary).clickable {
            displayText = !displayText
        }){
            val textModifier = Modifier.padding(horizontal = 10.dp).animateContentSize().fillMaxWidth()
            val textSelector = if (displayText) {weatherBean.getResume().take(20) + "..."}else{weatherBean.getResume()}
            Text(modifier = textModifier, text = weatherBean.name ,fontSize = 20.sp, color = MaterialTheme.colorScheme.onTertiary)
            Text(modifier = textModifier, text = textSelector, fontSize = 14.sp, color = MaterialTheme.colorScheme.onTertiary)
        }
    }

}