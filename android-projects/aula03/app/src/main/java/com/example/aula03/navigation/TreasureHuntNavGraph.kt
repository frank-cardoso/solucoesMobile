package com.example.aula03.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.aula03.TreasureHuntViewModel
import com.example.aula03.ui.screens.GenericClueScreen
import com.example.aula03.ui.screens.HomeScreen
import com.example.aula03.ui.screens.TreasureScreen

@Composable
fun TreasureHuntNavGraph(
    navController: NavHostController = rememberNavController(),
    viewModel: TreasureHuntViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    NavHost(
        navController = navController,
        startDestination = TreasureRoute.Home.route,
        enterTransition = {
            fadeIn(animationSpec = tween(220)) +
                slideInHorizontally(
                    initialOffsetX = { it / 3 },
                    animationSpec = tween(220)
                )
        },
        exitTransition = {
            fadeOut(animationSpec = tween(180)) +
                slideOutHorizontally(
                    targetOffsetX = { -it / 4 },
                    animationSpec = tween(180)
                )
        },
        popEnterTransition = {
            fadeIn(animationSpec = tween(220)) +
                slideInHorizontally(
                    initialOffsetX = { -it / 3 },
                    animationSpec = tween(220)
                )
        },
        popExitTransition = {
            fadeOut(animationSpec = tween(180)) +
                slideOutHorizontally(
                    targetOffsetX = { it / 4 },
                    animationSpec = tween(180)
                )
        }
    ) {
        composable(TreasureRoute.Home.route) {
            HomeScreen(
                onStartClick = {
                    viewModel.startHunt()
                    navController.navigate(TreasureRoute.Clue1.route)
                }
            )
        }

        composable(TreasureRoute.Clue1.route) {
            GenericClueScreen(
                clueId = 1,
                riddle = "Eu te sigo o dia inteiro, mas desapareço na escuridão. Quem sou eu?",
                viewModel = viewModel,
                onBackClick = { navController.popBackStack() },
                onNextClick = { navController.navigate(TreasureRoute.Clue2.route) }
            )
        }

        composable(TreasureRoute.Clue2.route) {
            GenericClueScreen(
                clueId = 2,
                riddle = "Quanto mais alimento, maior fico. Se me der água, eu morro. O que sou?",
                viewModel = viewModel,
                onBackClick = { navController.popBackStack() },
                onNextClick = { navController.navigate(TreasureRoute.Clue3.route) }
            )
        }

        composable(TreasureRoute.Clue3.route) {
            GenericClueScreen(
                clueId = 3,
                riddle = "Tenho dentes, mas não mordo. Sirvo para abrir caminhos. O que sou?",
                viewModel = viewModel,
                onBackClick = { navController.popBackStack() },
                onNextClick = { navController.navigate(TreasureRoute.Treasure.route) }
            )
        }

        composable(TreasureRoute.Treasure.route) {
            TreasureScreen(
                elapsedSeconds = uiState.elapsedSeconds,
                onReachedTreasure = { viewModel.onTreasureReached() },
                onRestartClick = {
                    viewModel.restartHunt()
                    navController.navigate(TreasureRoute.Home.route) {
                        popUpTo(0) { inclusive = true }
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}
