package io.github.tscholze.cmpsample.model

import ApiRoutes
import androidx.compose.runtime.remember
import kotlinx.serialization.Serializable

data class CampaignRequestBody(val moduleName: String, val filterMap: HashMap<String, HashMap<String,String>>)

fun createHashMapForRequest():HashMap<String,String>{
    var hashMap = HashMap<String,String>()
    hashMap.apply {
        put("targetPosition","ALL_INDIA")
        put("type", "FP_HOMEPAGE_RESIDENTIAL")
        put("platform", "android")
        put("resCom", "R")
    }
    return hashMap
}

fun createHeadersForRequest():HashMap<String,String>{
    var hashMap = HashMap<String,String> ()
    hashMap.apply {
        put("Cookie","GOOGLE_SEARCH_ID=7872951689059109479;99_ab=11")
        put("AuthorizationToken", "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2OTEwNDA4NzcuMDk3MDUyMSwiUVAiOiJmZGM1Y2U3ZGRjNjk0ODRmYmIwNTc0OTZjNTA3NWE0MDhlNTQwNjU1NTMxZGMwYjJiMWVkNzI3YWRkNzcyZGNkIiwidiI6IjEiLCJCUCI6IjllN2E0MWE0ODYyNjM0Nzg4NWNlYzAyN2Q5ODQ4Njg4NTYzNWQ5MTA3NWU3ZDRiNDlhMmY4Mzk0N2I4MzExZjgiLCJ0eXBlIjoiSSIsImlhdCI6MTY5MDE3Njg3Ny4wOTgxNSwiZGF0YSI6IjMyNDNlMjVjYWNlOTg4MGJhYTJhMWYyNjFhYmM2MDU1ZTMzMTBiMDU1Mjg4NTE2MDJjYjMwZDQ2Y2U4ZTUzYjI2NGUyNmFjMGRiYTc2Yjg1ZDViZDllMzZjMDc1MGJjMDdiMWNhMTQ2NWE0MWI3NzgzZGIzZGIxYTczNDUxZGU3OWY4ZTRjNDFmMzkzNDhmZDJkYTNlZjE3MDZmZGJkODk4N2JmMDc0MzllMTFlNTRkYTc3ZjY3NGZlNDJhMTc4NWZlNGM3ODY0MDczNTg2ZDBjNmIwM2NkOGJmNTU1Mzc3In0.yNBS0QrV2ghYSl4GuxHCz0mdsZNi0Ik1kp-UM3iVT8A")
        put("Channel", "App")
        put("Platform", "android")
        put("User-Agent", "99acres android app")
        put("deviceId", "095774A7-F138-4655-A4A8-9E37DB11D030")
        put("AppVersionCode","263")
        put("OSVersion","16.2")
        put("session_id","-1")
    }
    return hashMap
}

data class NNFeaturedProjectModel(
    val darkModeEnabled: Boolean,
    val notificationEnabled: Boolean,
    val address:String,
    val advertiserIds: List<String>,
    val bedrooms:List<String>,
    val builderLogo:String,
    val cityName:String,
    val config:String,
    val coverImageUrl:String,
    val customTrackDataSdk:String,
    val isShortListed:Boolean,
    val location:Float,
    val manualOverideOrder:String,
    val maxBudget:Int,
    val minBudget:Int,
    val moneyPower:String,
    val priceInText:String,
    val projectId:String,
    val projectName:String,
    val propertyTypes:List<String>,
    val resCom:String,
    val tagText:String,
    val xidUrl:String



)

data class CampaignItem(
    val widgetTitle: String,
    val widgetSubTitle: String,
    val dataList: List<NNFeaturedProjectModel>
)
