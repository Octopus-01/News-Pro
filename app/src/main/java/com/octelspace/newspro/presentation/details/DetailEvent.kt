package com.octelspace.newspro.presentation.details

sealed class DetailEvent {
    object SaveArticle : DetailEvent()
}