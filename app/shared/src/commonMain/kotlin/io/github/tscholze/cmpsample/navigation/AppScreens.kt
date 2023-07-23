package io.github.tscholze.cmpsample.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ExitToApp
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.ThumbUp
import androidx.compose.ui.graphics.vector.ImageVector
import com.copperleaf.ballast.navigation.routing.Route
import com.copperleaf.ballast.navigation.routing.RouteAnnotation
import com.copperleaf.ballast.navigation.routing.RouteMatcher

enum class AppScreens(
    val title: String,
    val icon: ImageVector,
    routeFormat: String,
    override val annotations: Set<RouteAnnotation> = emptySet(),
) : Route {

    // MARK: - Screens -


    LocalData("Home", Icons.Rounded.Home, "/app/local-data"),
    RemoteData("Shortlist", Icons.Rounded.Favorite, "/app/remote-data"),
    OtherFeatures("Profile", Icons.Rounded.Person, "/app/other-features");

    // MARK: - Matcher -

    override val matcher: RouteMatcher = RouteMatcher.create(routeFormat)
}