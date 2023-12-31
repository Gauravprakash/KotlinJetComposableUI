package io.github.tscholze.cmpsample.composables.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.tscholze.cmpsample.model.ChipsMapper
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

val GetStartedTitles = listOf(
    ChipsMapper(id = "HP_BUY", name = "Buy", icon = "explore_buy.webp", preference = "S"),
    ChipsMapper(id = "HP_RENT", name = "Rent", icon = "explore_rent.webp", preference = "R"),
    ChipsMapper(id = "HP_PL", name = "Plot / Land", icon = "explore_plots_lands.webp", preference = "S"),
    ChipsMapper(id = "HP_CW_LEASE", name = "Co-working\nSpaces", icon = "explore_coworking_space.webp", preference = "L"),
    ChipsMapper(id = "HP_COM_BUY", name = "Buy\nCommercial", icon = "explore_buy_commercial.webp", preference = "S"),
    ChipsMapper(id = "HP_LEASE", name = "Lease\nCommercial", icon = "explore_commercial_lease.webp", preference = "L"),
    ChipsMapper(id = "HP_INSIGHTS", name = "Insights", icon = "Insights.webp", preference = "S"),
    ChipsMapper(id = "HP_PG", name = "PG", icon = "explore_pg.webp", preference = "S"),
    ChipsMapper(id = "SELL_RENT_PROPERTY", name = "Post a property", icon = "explore_post_property.webp", preference = "S")
)
@Composable
fun GetStarted(getStartedTitles: List<ChipsMapper>) {
    Column(
        verticalArrangement = Arrangement.spacedBy(4.dp),
        modifier = Modifier.padding(PaddingValues(vertical = 10.dp))
    ) {
        Text(
            "Get started with",
            style = MaterialTheme.typography.h5,
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 2.dp),
            color = Color(0xFF041533)
        )
        Text("Explore real estate options in top cities",
            fontSize = 12.sp,
             modifier = Modifier.padding(horizontal = 16.dp),
             color = Color(0xFF8993A4)
            )
        LazyRow(modifier = Modifier.padding(PaddingValues(horizontal = 12.dp, vertical = 10.dp))) {
            items(getStartedTitles) {
                CardItem(title = it.name, image = it.icon)
            }

        }
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun CardItem(title: String, image:String) {
    Card(
        modifier = Modifier.padding(horizontal = 4.dp)
            .width(120.dp).height(120.dp),
        elevation = 4.dp,
        shape = RoundedCornerShape(size = 10.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){

            Image(painterResource(image),contentDescription = null)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = title, textAlign = TextAlign.Center, fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Normal, fontSize = 13.sp)
        }

    }
}