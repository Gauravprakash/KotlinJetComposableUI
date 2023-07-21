package io.github.tscholze.cmpsample.composables.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import io.github.tscholze.cmpsample.model.ChipsMapper
import InsightsMapper
import io.github.tscholze.cmpsample.utils.RemoteImage
import io.github.tscholze.cmpsample.utils.makeHttpClient
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

val baseurl = "https://static.99acres.com/universalapp/img"
// Common module - shared code

val InsightToolItems = listOf(
    InsightsMapper(id = "1", name = "Price Trends", entityType = "PRT", imageUrl = "$baseurl/Price_Trends.png", heading = "Check Property Rates & Price Trends", subHeading = "in any city, locality or society", url = "", urlLabel = "Price Trends"),
    InsightsMapper(id = "2", name = "Locality Insights", entityType = "LI", imageUrl = "$baseurl/Locality_Insights.png", heading = "Get to know different localities before you buy/rent...", subHeading = "Check Prices, lifestyle, reviews & more", url = "", urlLabel = "Locality Insights"),
    InsightsMapper(id = "3", name = "Read Ratings & Reviews", entityType = "RNR", imageUrl = "$baseurl/Ratings_n_Reviews.png", heading = "What locals say about their locality / society?", subHeading = "Get to know from residents", url = "", urlLabel = "Read Ratings & Reviews"),
    InsightsMapper(id = "4", name = "Transaction Prices", entityType = "RGR", imageUrl = "$baseurl/Registry_Records.png", heading = "Check actual transaction values of different properties.", subHeading = "in any locality / society before you buy", url = "", urlLabel = "Transaction Prices"),
    InsightsMapper(id = "5", name = "My Property Insights", entityType = "PRP", imageUrl = "$baseurl/propIn.png", heading = "Check Insights about your Property", subHeading = "Track Prices | Analyse Supply-Demand", url = "", urlLabel = "My Property Insights"),
    InsightsMapper(id = "6", name = "Read Latest News", entityType = "NWS", imageUrl = "$baseurl/news.png", heading = "Stay up-to-date with latest Real Estate News", subHeading = "in your city or across India", url = "", urlLabel = "Read Latest News"),
    InsightsMapper(id = "7", name = "Check Articles", entityType = "ARTS", imageUrl = "$baseurl/article.png", heading = "Browse & Read handpicked Articles", subHeading = "to get answers for all your doubts", url = "", urlLabel = "Check Articles"),
    InsightsMapper(id = "8", name = "Check Guides", entityType = "GDS", imageUrl = "$baseurl/guide.png", heading = "Buying or Renting for the first time? Start with Guides", subHeading = "to learn all about Real Estate", url = "", urlLabel = "Check Guides"),
    InsightsMapper(id = "9", name = "Budget Calculator", entityType = "BDC", imageUrl = "$baseurl/Budget_Calculator.png", heading = "Check your Home buying budget", subHeading = "based on your savings & EMI", url = "", urlLabel = "Budget Calculator"),
    InsightsMapper(id = "10", name = "EMI Calculator", entityType = "EMI", imageUrl = "$baseurl/EMI_Calculator.png", heading = "Plan your Home loan better with our EMI calculator", subHeading = "and plan your budget right...", url = "", urlLabel = "EMI Calculator"),
    InsightsMapper(id = "11", name = "Home Loan Eligibility Calculator", entityType = "HLC", imageUrl = "$baseurl/img_014.png", heading = "Home Loan Eligibility Calculator", subHeading = "based on your borrowing capacity", url = "", urlLabel = "Check Now"),
    InsightsMapper(id = "12", name = "Area Convertor", entityType = "ACT", imageUrl = "$baseurl/Area_Convertor.png", heading = "Check area in any unit —sq.ft to yards and more", subHeading = "Convert  area across 20+ Units", url = "", urlLabel = "Area Converter")
)
val client = makeHttpClient()

@Composable
fun GetInsightTools(insightToolItems: List<InsightsMapper>) {
    Column(
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            "Insights & Tools",
            style = MaterialTheme.typography.h6,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 2.dp),
            color = Color(0xFF041533)
        )
        Text("Go from browsing to buying",
            modifier = Modifier.padding(horizontal = 16.dp),
            color = Color(0xFF8993A4)
        )
        LazyRow() {
            items(insightToolItems) {
                it
                  InsightsItem(title = it.name, image = it.imageUrl)
                // CardItem(title = it.name, image = it.icon)
            }

        }
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun InsightsItem(title: String, image:String) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .width(200.dp).height(200.dp),
        elevation = 8.dp,
        shape = RoundedCornerShape(size = 8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            // Cover image
            RemoteImage(
                client,
                image,
                modifier = Modifier.width(80.dp).aspectRatio(2f),
                contentDescription = ""
            )
            // Image(painterResource(image),contentDescription = null)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = title, textAlign = TextAlign.Center, fontFamily = FontFamily.Default, fontWeight = FontWeight.Normal)
        }

    }
}