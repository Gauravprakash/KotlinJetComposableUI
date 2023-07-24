package io.github.tscholze.cmpsample.composables.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import io.github.tscholze.cmpsample.utils.RemoteImage

@Composable
fun HandPickedProject() {
    LazyRow(modifier = Modifier.padding(vertical = 20.dp, horizontal = 16.dp)) {
        items(1){
            ProjectItem()
        }
    }
}

@Composable
fun ProjectItem(){
    Box(modifier =Modifier.width(312.dp).height(430.dp),
        ){
        RemoteImage(
            client,
            "https://newprojects.99acres.com/projects/m3m_india/m3m_the_cullinan/images/vttm6wm_1689846668_434738412_med.jpg",
            modifier = Modifier.fillMaxWidth().fillMaxHeight()
                .clip(RoundedCornerShape(8.dp)),
            contentDescription = ""
        )

        Card(modifier = Modifier.width(100.dp)
            .height(50.dp).align(Alignment.BottomCenter).offset(y= 20.dp), elevation = 8.dp) {

        }
    }
}