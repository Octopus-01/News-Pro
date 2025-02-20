package com.octelspace.newspro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.lifecycle.lifecycleScope
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.octelspace.newspro.data.local.NewsDao
import com.octelspace.newspro.presentation.navgraph.NavGraph
import com.octelspace.newspro.ui.theme.NewsProTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    val viewModel by viewModels<MainViewModel>()
    @Inject
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // To support Edge To Edge enableEdgeToEdge()
        WindowCompat.setDecorFitsSystemWindows(window, false)

        installSplashScreen().apply {
            setKeepOnScreenCondition{
                viewModel.splashCondition
            }
        }

        setContent {
            NewsProTheme {

                val isSysteminDarkMode = isSystemInDarkTheme()
                val SystemUiController = rememberSystemUiController()

                SideEffect {
                    SystemUiController.setSystemBarsColor(
                        color = Color.Transparent,
                        darkIcons = !isSysteminDarkMode
                    )
                }

                Box(modifier = Modifier.background(color = MaterialTheme.colorScheme.background)){

                    val startDestination = viewModel.startDestination
                    NavGraph(startDestination = startDestination)

                }
            }
        }
    }
}