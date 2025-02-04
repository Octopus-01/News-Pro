package com.octelspace.newspro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import com.octelspace.newspro.presentation.navgraph.NavGraph
import com.octelspace.newspro.ui.theme.NewsProTheme
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // To support Edge To Edge enableEdgeToEdge()
        //WindowCompat.setDecorFitsSystemWindows(window, false)
        installSplashScreen().apply {
            setKeepOnScreenCondition{
                viewModel.splashCondition
            }
        }

        setContent {
            NewsProTheme {
                Box(modifier = Modifier.background(color = MaterialTheme.colorScheme.background)){

                    val startDestination = viewModel.startDestination
                    NavGraph(startDestination = startDestination)

                }
            }
        }
    }
}