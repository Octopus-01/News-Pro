package com.octelspace.newspro.presentation.navgraph

sealed class Routs(
    val routs : String
) {
    object OnBoardingScreen : Routs("onBoardingScreen")
    object HomeScreen : Routs("homeScreen")
    object SearchScreen : Routs("searchScreen")
    object BookMarkScreen: Routs("bookMarkScreen")
    object DetailsScreen: Routs("detailsScreen")
    object AppStartNavigation: Routs("appStartNavigation")
    object NewsNavigation: Routs("newsNavigation")
    object NewsNavigatorScreen: Routs("newsNavigator")

}