package io.github.tscholze.cmpsample.composables.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.tscholze.cmpsample.model.SectionMapper
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun BigSectionCards(sectionMapper: SectionMapper) {
    Column(Modifier.padding(PaddingValues(horizontal = 16.dp, vertical = 20.dp))) {
        Text(
            sectionMapper.title,
            style = MaterialTheme.typography.h5,
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp,
            modifier = Modifier.padding(vertical = 2.dp),
            color = Color(0xFF041533)
        )
        Text(sectionMapper.subtitle,
            fontSize = 12.sp,
            color = Color(0xFF8993A4)
        )
        Image(
            painterResource(sectionMapper.image),
            null,
            Modifier.fillMaxWidth().padding(vertical = 10.dp),
            contentScale = ContentScale.FillWidth
        )
        Row(verticalAlignment =Alignment.CenterVertically ) {
            Text(sectionMapper.cta,
                style = MaterialTheme.typography.body1,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp,
                modifier = Modifier.padding(vertical = 10.dp),
                color = Color(0xFF041533)
            )
            Icon(
                painterResource("arrow_right.webp"),contentDescription = null
                , modifier = Modifier.padding(horizontal = 4.dp))
        }
        Text(sectionMapper.ctaText,
            fontSize = 10.sp,
            color = Color(0xFF8993A4)
        )
        Divider(modifier = Modifier.fillMaxWidth()
            .padding(top = 15.dp),
        color = Color(0xFFEBECF0),
        thickness = 1.6.dp)
    }
}