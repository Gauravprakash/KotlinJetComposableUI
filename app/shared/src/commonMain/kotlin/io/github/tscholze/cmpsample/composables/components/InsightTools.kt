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
import androidx.compose.foundation.background
// import androidx.compose.foundation.layout.BoxScopeInstance.align
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.contentColorFor
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import io.github.tscholze.cmpsample.utils.RemoteImage
import io.github.tscholze.cmpsample.utils.makeHttpClient
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

val baseurl = "https://static.99acres.com/universalapp/img"
// Common module - shared code

val InsightToolItems = listOf(
    InsightsMapper(id = "1", name = "Price Trends", entityType = "PRT", imageUrl = "$baseurl/PriceTrend2Msite.png", heading = "Price Trends", subHeading = "Check property rates and prices", url = "", urlLabel = "Price Trends"),
    InsightsMapper(id = "2", name = "Locality Insights", entityType = "LI", imageUrl = "$baseurl/LocalityInsights2Msite.png", heading = "Locality Insights", subHeading = "Know more about different localities", url = "", urlLabel = "Locality Insights"),
    InsightsMapper(id = "3", name = "Read Ratings & Reviews", entityType = "RNR", imageUrl = "$baseurl/ReviewsRatings2Msite.png", heading = "Reviews & Ratings", subHeading = "Know what residents say", url = "", urlLabel = "Read Ratings & Reviews"),
    InsightsMapper(id = "4", name = "Transaction Prices", entityType = "RGR", imageUrl = "$baseurl/TransactionPrices2Msite.png", heading = "Transaction Prices", subHeading = "Check property transaction values", url = "", urlLabel = "Transaction Prices"),
    InsightsMapper(id = "5", name = "My Property", entityType = "PRP", imageUrl = "$baseurl/AboutMyProperty2Msite.png", heading = "Check Insights about your Property", subHeading = "Track prices & analyse market demands", url = "", urlLabel = "My Property"),
    InsightsMapper(id = "6", name = "Read Latest News", entityType = "NWS", imageUrl = "$baseurl/ReadIcons2Msite.png", heading = "Read Latest News", subHeading = "Around real estate and allied industries", url = "", urlLabel = "Read Latest News"),
    InsightsMapper(id = "7", name = "Check Articles", entityType = "ARTS", imageUrl = "$baseurl/GuidesDesktop.png", heading = "Check Articles", subHeading = "On trending topics and policy updates", url = "", urlLabel = "Check Articles"),
    InsightsMapper(id = "8", name = "User Guides", entityType = "GDS", imageUrl = "$baseurl/NewsDesktop.png", heading = "User Guides", subHeading = "To help home buyers, tenants and sellers", url = "", urlLabel = "Check Guides"),
    InsightsMapper(id = "9", name = "Budget Calculator", entityType = "BDC", imageUrl = "$baseurl/BudgetIcon2Msite.png", heading = "Budget Calculator", subHeading = "Check your affordability range for buying home", url = "", urlLabel = "Budget Calculator"),
    InsightsMapper(id = "10", name = "EMI Calculator", entityType = "EMI", imageUrl = "$baseurl/EMICalculator2Msite.png", heading = "EMI Calculator", subHeading = "Calculate your home loan EMI", url = "", urlLabel = "EMI Calculator"),
    InsightsMapper(id = "11", name = "Home Loan Eligibility Calculator", entityType = "HLC", imageUrl = "$baseurl/LoanEligibility2Msite.png", heading = "Loan Eligibility", subHeading = "See what you can borrow for your home", url = "", urlLabel = "Check Now"),
    InsightsMapper(id = "12", name = "Area Convertor", entityType = "ACT", imageUrl = "$baseurl/AreaConverter2Msite.png", heading = "Area Converter", subHeading = "Convert one area into any other easily", url = "", urlLabel = "Area Converter")
)
val client = makeHttpClient()

@OptIn(ExperimentalResourceApi::class)
@Composable
fun GetInsightTools(insightToolItems: List<InsightsMapper>) {
    Column(
        verticalArrangement = Arrangement.spacedBy(4.dp),
        modifier = Modifier.padding(PaddingValues(vertical = 20.dp)).background(color = Color(0xFFf0f9ff))
    ) {
        Spacer(modifier = Modifier.height(8.dp))
        Row( Modifier
            .fillMaxWidth()
            .padding(8.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically){
            Row(verticalAlignment = Alignment.CenterVertically ) {
                Image(
                    painterResource("batch_prediction.webp"),contentDescription = null)
                    //, modifier = Modifier.padding(horizontal = 4.dp))
                Column(
                    verticalArrangement = Arrangement.spacedBy(4.dp),
                ){
                    Text(
                        "Insights & Tools",
                        style = MaterialTheme.typography.h5,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 20.sp,
                        modifier = Modifier.padding(horizontal = 8.dp),
                        color = Color(0xFF041533)
                    )
                    Text("Go from browsing to buying",
                        fontSize = 12.sp,
                        modifier = Modifier.padding(horizontal = 8.dp),
                        color = Color(0xFF8993A4)
                    )
                }


            }
            // Button

            Button(
                onClick = { print("View All tapped") },
                modifier = Modifier.padding(start = 8.dp),
                colors = ButtonDefaults.textButtonColors(contentColor = Color(0xFF0078DB),
                    backgroundColor = Color.Transparent

                ),
                elevation = ButtonDefaults.elevation(
                    defaultElevation = 0.dp,
                    pressedElevation = 0.dp,
                    disabledElevation = 0.dp
                ),
            ) {
                Text("View All", style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.SemiBold ))


            }

        }



        LazyRow(modifier = Modifier.padding(start = 10.dp, end = 10.dp)) {
            items(insightToolItems) {
                it
                  InsightsItem(title = it.heading, subTitle = it.subHeading, image = it.imageUrl)
                // CardItem(title = it.name, image = it.icon)
            }

        }
        Spacer(modifier = Modifier.height(8.dp))
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun InsightsItem(title: String, subTitle:String, image:String) {
    Card(
        modifier = Modifier
            .padding(PaddingValues(vertical = 16.dp, horizontal = 6.dp))
            .width(200.dp).height(200.dp),
        shape = RoundedCornerShape(size = 5.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ){
            RemoteImage(
                client,
                image,
                modifier = Modifier.width(24.dp).height(24.dp).drawBehind {
                    drawCircle(
                        color = Color(0xFFf0f9ff),
                        radius = this.size.maxDimension
                    )
                },
                contentDescription = ""
            )
            // Image(painterResource(image),contentDescription = null)
//            Spacer(modifier = Modifier.height(8.dp))
            Row(modifier = Modifier.padding(top = 25.dp, start = 6.dp), horizontalArrangement = Arrangement.Start) {
                Text(title,
                    style = MaterialTheme.typography.body1,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp,
                    color = Color(0xFF041533)
                )
                Icon(
                    painterResource("arrow_right.webp"),contentDescription = null
                    , modifier = Modifier.padding(horizontal = 4.dp))
            }
            Text(subTitle,
                style = MaterialTheme.typography.subtitle1,
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp,
                modifier = Modifier.padding(vertical = 2.dp, horizontal = 8.dp),
                color = Color(0xFF8993A4)
            )

        }

    }
}