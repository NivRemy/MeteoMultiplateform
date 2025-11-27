package org.example.project.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import org.example.project.model.KtorWeatherAPI
import org.example.project.model.MainBean
import org.example.project.model.WeatherBean
import org.example.project.model.WeatherDescriptionBean
import org.example.project.model.WindBean


//suspend fun main(){
//    val viewModel = MainViewModel()
//
//    viewModel.loadWeathers("")
//    //Affichage de la liste (qui doit être remplie) contenue dans la donnée observable
//    while (viewModel.runInProgress.value) {
//        println("List : ${viewModel.dataList.value}" )
//        println(viewModel.errorMessage.value)
//        delay(500)
//    }
////    viewModel.runInProgress.collect(){
////        if (!it){
////            println("List : ${viewModel.dataList.value}" )
////        }
////    }
//}

suspend fun main() {
    /*val viewModel = MainViewModel()
    viewModel.loadWeathers("")
    //viewModel.loadWeathers("Paris")
    //attente
    while (viewModel.runInProgress.value){
        delay(500)
    }
    //Affichage de la liste et du message d'erreur
    println("List : ${viewModel.dataList.value}" )
    println("ErrorMessage : ${viewModel.errorMessage.value}" )*/
}

open class MainViewModel(
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
    val ktorWeatherApi: KtorWeatherAPI
) : ViewModel() {
    //MutableStateFlow est une donnée observable
    val dataList = MutableStateFlow(emptyList<WeatherBean>())
    val errorMessage = MutableStateFlow("")
    val runInProgress = MutableStateFlow(false)


    //init { //Création d'un jeu de donnée au démarrage
        /*loadFakeData()
        println("MainViewModel")*/
    //}

    open fun loadWeathers(cityName:String) : Job {
        runInProgress.value = true
        errorMessage.value = ""

        val job = viewModelScope.launch(dispatcher) {
            //TODO récupérer des données et les mettre dans dataList
            try{
                dataList.value = ktorWeatherApi.loadWeathers(cityName)
            } catch (e: Exception) {
                e.printStackTrace()
                errorMessage.value = e.message ?: "C KC"
            } finally {
                runInProgress.value = false
            }
        }
        return job
    }

    fun loadFakeData(runInProgress :Boolean = false, errorMessage:String = "" ) {
        this.runInProgress.value = runInProgress
        this.errorMessage.value = errorMessage
        dataList.value = listOf(
            WeatherBean(
                id = 1,
                name = "Paris",
                main = MainBean(temp = 18.5),
                weather = listOf(
                    WeatherDescriptionBean(
                        description = "ciel dégagé",
                        icon = "https://picsum.photos/200"
                    )
                ),
                wind = WindBean(speed = 5.0)
            ),
            WeatherBean(
                id = 2,
                name = "Toulouse",
                main = MainBean(temp = 22.3),
                weather = listOf(
                    WeatherDescriptionBean(
                        description = "partiellement nuageux",
                        icon = "https://picsum.photos/201"
                    )
                ),
                wind = WindBean(speed = 3.2)
            ),
            WeatherBean(
                id = 3,
                name = "Toulon",
                main = MainBean(temp = 25.1),
                weather = listOf(
                    WeatherDescriptionBean(
                        description = "ensoleillé",
                        icon = "https://picsum.photos/202"
                    )
                ),
                wind = WindBean(speed = 6.7)
            ),
            WeatherBean(
                id = 4,
                name = "Lyon",
                main = MainBean(temp = 19.8),
                weather = listOf(
                    WeatherDescriptionBean(
                        description = "pluie légère",
                        icon = "https://picsum.photos/203"
                    )
                ),
                wind = WindBean(speed = 4.5)
            )
        ).shuffled() //shuffled() pour avoir un ordre différent à chaque appel
    }
}