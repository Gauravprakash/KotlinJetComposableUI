package io.github.tscholze.cmpsample.composables.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Modifier as Modifier1

/**
 * Generic text query search view.
 * @param state Mutable state string that contains the typed query.
 */
@Composable
internal fun SearchView(state: MutableState<String>) {

    // MARK: - Components -
    
    @Composable
    fun LeadingIcon() {
        Icon(
            Icons.Default.Search,
            tint = Color(0xFFA3DAFF),
            contentDescription = "Search icon",
            modifier = Modifier.padding(5.dp).size(24.dp)
        )
    }

    @Composable
    fun TrailingIcon(state: MutableState<String>) {
        if (state.value != "") {
            IconButton(
                onClick = { state.value = "" }
            ) {
                Icon(
                    Icons.Default.Close,
                    contentDescription = "Clear icon",
                    modifier = Modifier1.padding(15.dp).size(24.dp)
                )
            }
        }
    }

    // MARK: - UI -
Card(elevation = 6.dp, border = BorderStroke(1.5.dp,Color(0xFFA3DAFF)),
    modifier = Modifier.fillMaxWidth().offset(y = (-30).dp)
        .padding(PaddingValues(horizontal = 20.dp)),
        shape = RoundedCornerShape(10.dp)
) {
    OutlinedTextField(
        modifier = Modifier1.fillMaxWidth()
            .background(Color.White),
        textStyle = TextStyle(color = Color.Black, fontSize = 12.sp),
        singleLine = true,
        placeholder = { Text("Search city, locality, projects…", fontSize = 14.sp, fontWeight = FontWeight.Normal) },
        value = state.value,
        onValueChange = { state.value = it },
        leadingIcon = { LeadingIcon() },
        trailingIcon = { TrailingIcon(state) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            disabledBorderColor = Color(0xFFA3DAFF),
            focusedBorderColor = Color(0xFFA3DAFF),
            unfocusedBorderColor = Color(0xFFA3DAFF)
        )
    )
}
}