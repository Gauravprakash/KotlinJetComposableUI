package io.github.tscholze.cmpsample.composables.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource


/**
 * A simple banner that renders the given text
 *
 * @param text Text that should be rendered.
 */
@OptIn(ExperimentalResourceApi::class)
@Composable
internal fun Banner() {
    Box(
        modifier = Modifier.fillMaxWidth()
            .background(MaterialTheme.colors.secondary)
    ) {
        Image(
            painterResource("hp_default.png"),contentDescription = null,
            modifier = Modifier.fillMaxWidth().height(200.dp),
            contentScale = ContentScale.FillWidth
        )

    }
}