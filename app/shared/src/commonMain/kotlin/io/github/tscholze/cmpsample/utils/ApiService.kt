
import io.github.tscholze.cmpsample.utils.makeHttpClient
import io.ktor.client.HttpClient

import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.post
import io.ktor.http.contentType
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpMethod

import io.ktor.http.URLBuilder
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.runtime.rememberCoroutineScope
import io.github.tscholze.cmpsample.model.createHashMapForRequest
import io.github.tscholze.cmpsample.model.createHeadersForRequest
import io.ktor.client.engine.HttpClientEngine
import io.ktor.http.Url
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

val client by lazy {
    HttpClient()
}

object ApiRoutes {
    private const val BASE_URL = "https://www.99acres.com/"
    private const val AGGREGATOR_END_POINT = "api-aggregator"
    const val CAMPAIGN_URL = "$BASE_URL/$AGGREGATOR_END_POINT/seller/onlineCampaign/get?source=PersonalizedHP_IOS&moduleName=CAMPAIGN_SYSTEM&campaignName=FP"

}

object ApiService {
    suspend fun makeRequest(){
        var scope = MainScope()
        val url = Url(urlString = ApiRoutes.CAMPAIGN_URL)
        val response = client.post(url){
            val hashing =  createHashMapForRequest()
            var hashMap = HashMap<String,HashMap<String,String>>()
            hashMap.apply {
                put("filterMap", hashing)
            }
            method = HttpMethod.Post
            setBody(hashMap)
            // val headers = createHeadersForRequest()
            header("Cookie","GOOGLE_SEARCH_ID=7872951689059109479;99_ab=11")
            header("AuthorizationToken", "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2OTEwNDA4NzcuMDk3MDUyMSwiUVAiOiJmZGM1Y2U3ZGRjNjk0ODRmYmIwNTc0OTZjNTA3NWE0MDhlNTQwNjU1NTMxZGMwYjJiMWVkNzI3YWRkNzcyZGNkIiwidiI6IjEiLCJCUCI6IjllN2E0MWE0ODYyNjM0Nzg4NWNlYzAyN2Q5ODQ4Njg4NTYzNWQ5MTA3NWU3ZDRiNDlhMmY4Mzk0N2I4MzExZjgiLCJ0eXBlIjoiSSIsImlhdCI6MTY5MDE3Njg3Ny4wOTgxNSwiZGF0YSI6IjMyNDNlMjVjYWNlOTg4MGJhYTJhMWYyNjFhYmM2MDU1ZTMzMTBiMDU1Mjg4NTE2MDJjYjMwZDQ2Y2U4ZTUzYjI2NGUyNmFjMGRiYTc2Yjg1ZDViZDllMzZjMDc1MGJjMDdiMWNhMTQ2NWE0MWI3NzgzZGIzZGIxYTczNDUxZGU3OWY4ZTRjNDFmMzkzNDhmZDJkYTNlZjE3MDZmZGJkODk4N2JmMDc0MzllMTFlNTRkYTc3ZjY3NGZlNDJhMTc4NWZlNGM3ODY0MDczNTg2ZDBjNmIwM2NkOGJmNTU1Mzc3In0.yNBS0QrV2ghYSl4GuxHCz0mdsZNi0Ik1kp-UM3iVT8A")
            header("Channel", "App")
            header("Platform", "android")
            header("User-Agent", "99acres android app")
            header("deviceId", "095774A7-F138-4655-A4A8-9E37DB11D030")
            header("AppVersionCode","263")
            header("OSVersion","16.2")
            header("session_id","-1")

        }
        println("Response body:")
        println(response)

}

}