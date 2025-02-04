package com.octelspace.newspro

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.octelspace.newspro.domain.usecases.AppEntryUseCases
import com.octelspace.newspro.presentation.navgraph.Routs
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val appEntryUseCases: AppEntryUseCases
): ViewModel() {
    var splashCondition by mutableStateOf(true)
        private set

    var startDestination by mutableStateOf(Routs.AppStartNavigation.routs)
        private set

    init {
        appEntryUseCases.readAppEntry().onEach {
            shouldStartFromHomeScreen ->
            if(shouldStartFromHomeScreen){
                startDestination = Routs.NewsNavigation.routs
            }else{
                startDestination = Routs.AppStartNavigation.routs
        }
            delay(300)

            splashCondition = false
        }.launchIn(viewModelScope)
    }
}