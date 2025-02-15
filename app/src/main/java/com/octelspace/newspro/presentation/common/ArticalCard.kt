package com.octelspace.newspro.presentation.common

import android.widget.Space
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.octelspace.newspro.R
import com.octelspace.newspro.domain.model.Article
import com.octelspace.newspro.presentation.onboarding.Dimention.ArticalCardSize
import com.octelspace.newspro.presentation.onboarding.Dimention.ExtraSmallPadding
import com.octelspace.newspro.presentation.onboarding.Dimention.ExtraSmallPadding2
import com.octelspace.newspro.presentation.onboarding.Dimention.SmallIconSize

@Composable
fun ArticalCard(
    modifier: Modifier = Modifier,
    artical: Article,
    onCLick: () -> Unit
){
    Row(modifier = Modifier.clickable { onCLick() }) {
        AsyncImage(
            modifier = Modifier
                .size(ArticalCardSize)
                .clip(MaterialTheme.shapes.medium),
            model = ImageRequest.Builder(LocalContext.current).data(artical.urlToImage).build(),
            contentDescription = null
        )
    Column(
        verticalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .padding(horizontal = ExtraSmallPadding)
            .height(ArticalCardSize)
    ) {
        Text(
            text = artical.title,
            style = MaterialTheme.typography.bodyMedium,
            color = colorResource(R.color.text_title),
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
        Row(
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = artical.source.name,
                style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                color = colorResource(id = R.color.body),
                )
            Spacer( modifier = Modifier.width(ExtraSmallPadding2))
            Icon(
                painter = painterResource(id = R.drawable.ic_time),
                contentDescription = null,
                modifier = Modifier.size(SmallIconSize),
                tint = colorResource(id = R.color.body)

            )
            Spacer( modifier = Modifier.width(ExtraSmallPadding2))
            Text(
                text = artical.publishedAt,
                style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                color = colorResource(id = R.color.body),
            )
        }

    }
    }
}