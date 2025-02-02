package com.octelspace.newspro.presentation.onboarding

sealed class OnBoardingEvent {
    object SaveAppEntry : OnBoardingEvent()
}