package io.github.tscholze.cmpsample.composables.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.copperleaf.ballast.navigation.vm.Router
import io.github.tscholze.cmpsample.composables.components.Banner
import io.github.tscholze.cmpsample.composables.components.BigSectionCards
import io.github.tscholze.cmpsample.composables.components.GetInsightTools
import io.github.tscholze.cmpsample.composables.components.GetStarted
import io.github.tscholze.cmpsample.composables.components.GetStartedTitles
import io.github.tscholze.cmpsample.composables.components.InsightToolItems
import io.github.tscholze.cmpsample.composables.components.SearchView
import io.github.tscholze.cmpsample.composables.layouts.PageLayout
import io.github.tscholze.cmpsample.model.LicensePlateLocation
import io.github.tscholze.cmpsample.model.SectionMapper
import io.github.tscholze.cmpsample.navigation.AppScreens
import io.github.tscholze.cmpsample.utils.ResourceReader

/**
 * Sample screen to demonstrate the kmm approach of locally fetched resources.
 * See file `data.csv` for more information.
 *
 * Caution:
 * The file has to be embedded separately for iOS and Android.
 */
@Composable
internal fun LocalResourceScreen(router: Router<AppScreens>) {

    // MARK: - Inner properties -

    val textState = remember { mutableStateOf("") }
    val allValues = parseData()

    // MARK: - Inner helper -

    fun filterPlates(query: String): List<LicensePlateLocation> {
        if (query.isEmpty()) {
            return allValues
        }

        return allValues.filter {
            it.id.startsWith(query, ignoreCase = true)
                    || it.state.startsWith(query, ignoreCase = true)
                    || it.state.startsWith(query, ignoreCase = true)
        }
    }

    // MARK: - UI -

    PageLayout(AppScreens.LocalData.title, router) {
       LazyColumn(
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
           item {
               Banner()
           }
           item {
                SearchView(textState)
           }
           item {
               GetStarted(GetStartedTitles)
           }
           item {
               GetInsightTools(InsightToolItems)
           }
           item {
               BigSectionCards(
                   SectionMapper(
                       "Buying a home",
                       "Apartments, land, builder floors, villas and more",
                       "Buy.webp",
                       "Explore all home buying options",
                       "Over 5200 properties and 450 projects",
                       "S",
                       "R"
                   )
               )
           }
           // add Recommended project here
           item {
               BigSectionCards(
                   SectionMapper(
                       "Renting a home",
                       "Apartments, land, builder floors, villas and more",
                       "rentingahome.webp",
                       "Explore all home renting options",
                       "Over 1400 properties | 750+ owner listed",
                       "S",
                       "R_R"
                   )
               )
           }
           item {
               BigSectionCards(
                   SectionMapper(
                       "Buy Plots/Land",
                       "Explore Residential and Commercial Plots/Land",
                       "explore_plots_and_lands.webp",
                       "Explore all Plots/Land Options",
                       "1300+ Residential properties | 210+ Commercial Properties",
                       "S",
                       "R"
                   )
               )
           }
           item {
               BigSectionCards(
                   SectionMapper(
                       "Selling/ Renting your property",
                       "Close the deal faster with 99acres",
                       "rentingselling.webp",
                       "Post property for FREE",
                       "Option to get assistance & free verification",
                       "",
                       ""
                   )
               )
           }
           item {
               BigSectionCards(
                   SectionMapper(
                       "PG and co-living",
                       "Organised, owner and broker listed PGs",
                       "pgandcoliving.webp",
                       "Explore all PG and co-living options",
                       "Over 70 properties | 60+ owners listed",
                       "P",
                       "R"
                   )
               )
           }
           item {
               BigSectionCards(
                   SectionMapper(
                       "Buying a commercial property",
                       "Shops, offices, land, factories, warehouses and more",
                       "buyingcommercial.webp",
                       "Explore all commercial buying options",
                       "Over 590 properties and 50 projects",
                       "S",
                       "C"
                   )
               )
           }
           item {
               BigSectionCards(
                   SectionMapper(
                       "Leasing a commercial property",
                       "Shops, offices, land, factories, warehouses and more",
                       "leasecommercial.webp",
                       "Explore all commercial leasing options",
                       "Over 670 properties | 450+ owners listed",
                       "L",
                       "C"
                   )
               )
           }
        }
    }
}

// MARK: - Private helper -

private fun parseData(): List<LicensePlateLocation> {
    // 1. Prepare raw data from CSV file.
    val rawData = ResourceReader()
        .readResource("data.csv")
        .lines()
        .drop(1)
        .map { it.split(",") }

    // 2. Parse given raw data into LicensePlateLocation objects.
    val plates = mutableListOf<LicensePlateLocation>()
    for (column in rawData) {
        // 2.1 Try to parse raw data
        try {
            // 2.1.1 Validate input.
            if (column.count() != 3) continue

            // 2.1.2 Add valid parsed locations to list
            plates.add(LicensePlateLocation(column[0], column[1], column[2]))
        } catch (e: Exception) {
            // 2.2 Catch and log all thrown exception
            println("Ignoring raw data column: $column")
        }
    }

    // Return found LicensePlateLocations
    return plates
}