package codechallenges.misc

import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

/*
 * Complete the 'findCountry' function below.
 *
 * The function is expected to return a STRING_ARRAY.
 * The function accepts following parameters:
 *  1. STRING region
 *  2. STRING keyword
 * Base URL for copy/paste:
 * https://jsonmock.hackerrank.com/api/countries/search?region={region} &name={keyword}
 */

//fun findCountry(region: String, keyword: String): Array<String> {
//    // Make api call
//    val url = "https://jsonmock.hackerrank.com/api/countries/search?region=$region&name=${keyword}"
//    val httpClient = HttpClient.newBuilder().build()
//
//
//    // Create response
//    val request = HttpRequest.newBuilder()
//        .GET()
//        .uri(URI.create(url))
//        .build()
//
//    val response = httpClient.send(request, HttpResponse.BodyHandlers.ofString())
//
//    // Parse response
//    val body = response.body()
//    println("Body: $body")
//
//    // Parse JSon
//    val gson = Gson()
//
//    val jsonObject = gson.fromJson(body, JsonObject::class.java)
//
//    val responseData = jsonObject["data"]
//
//    val jsonList = gson.fromJson(responseData, JsonArray::class.java)
//
//    val pairList = mutableListOf<Pair<String, String>>()
//    for (item in jsonList) {
//        val countryObject = gson.fromJson(item, JsonObject::class.java)
//
//        val pair = Pair(countryObject["name"], countryObject["population"])
//        pairList.add(pair)
//    }
//}

fun main(args: Array<String>) {
    val region = "Africa"

    val keyword = "KE"

//    val result = findCountry(region, keyword)

//    println(result.joinToString("\n"))
}