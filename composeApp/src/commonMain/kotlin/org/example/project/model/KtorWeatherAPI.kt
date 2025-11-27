package org.example.project.model

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.delay
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

suspend fun main() {
    /*val list : List<WeatherBean> = KtorWeatherAPI.loadWeathers("Nice")
    println(list.forEach { println(it.getResume()) })
    KtorWeatherAPI.close()*/
}

class KtorWeatherAPI (val client: HttpClient) {
    private val API_URL =
    "https://api.openweathermap.org/data/2.5/"

    //Création et réglage du client
    // Fait dans Koin
    /*private val client  = HttpClient {
        install(ContentNegotiation) {
            json(Json { ignoreUnknownKeys = true }, contentType = ContentType.Any)
        }
        expectSuccess = true //Exception si code >= 300
        //engine { proxy = ProxyBuilder.http("monproxy:1234") }
    }*/

    //GET Le JSON reçu sera parser en List<MuseumObject>,
    //Crash si le JSON ne correspond pas
    suspend fun loadWeathers(name :String) :List<WeatherBean> {
        if (name.length < 3 ){
            throw Exception("City name must be at least 3 characters")
        }
        delay(2000)
        return client.get(API_URL + "find?q=$name&appid=b80967f0a6bd10d23e44848547b26550&units=metric&lang=fr"){
//            headers {
//                append("Authorization", "Bearer YOUR_TOKEN")
//                append("Custom-Header", "CustomValue")
//            }
        }.body <WeatherApiResponse>().list.onEach { weatherBean -> weatherBean.weather.forEach { it.icon = "https://openweathermap.org/img/wn/${it.icon}@4x.png" } }
        //possibilité de typer le body
        //.body<List<MuseumObject>>()
    }

    //POST
  /*  suspend fun postData(newObject: MuseumObject): MuseumObject {
        return client.post(API_URL){
            setBody(newObject)
        }.body()
    }*/

    //Ferme le Client mais celui ci ne sera plus utilisable. Uniquement pour le main
    fun close() = client.close()
}




@Serializable
data class WeatherApiResponse (val list:List<WeatherBean >)


@Serializable
data class WeatherBean (
    val id:Int,
    val name:String,
    val wind:WindBean,
    val main:MainBean,
    val weather:List<WeatherDescriptionBean>
) {
    fun getResume() :String {
      return "Il fait ${main.temp}° à $name (id=$id) avec un vent de ${wind.speed} m/s \n -Description : ${weather.firstOrNull()?.description ?: "-"} \n -Icône : ${weather.firstOrNull()?.icon ?: "-"} "
    }
}

@Serializable
data class WindBean (var speed:Double)

@Serializable
data class MainBean (var temp:Double)

@Serializable
data class WeatherDescriptionBean (var description:String, var icon:String)