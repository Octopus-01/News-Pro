package com.loc.newsapp.presentation

import androidx.annotation.DrawableRes
import com.octelspace.newspro.R

data class Page(
    val title : String,
    val description : String,
    @DrawableRes val image : Int,
    )

val  pages = listOf(
    Page(
        title = "Title of this page 1 ",
        description = "Description of this page ",
        image = R.drawable.onboarding1
    ),
    Page(
        title = "Title of this page 2",
        description = "Description of this page ",
        image = R.drawable.onboarding2
    ),
    Page(
        title = "Title of this page 3",
        description = "Description of this page ",
        image = R.drawable.onboarding3
    )
)
