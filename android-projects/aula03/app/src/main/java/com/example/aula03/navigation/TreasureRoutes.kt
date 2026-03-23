package com.example.aula03.navigation

sealed class TreasureRoute(val route: String) {
    data object Home : TreasureRoute("home")
    data object Clue1 : TreasureRoute("clue1")
    data object Clue2 : TreasureRoute("clue2")
    data object Clue3 : TreasureRoute("clue3")
    data object Treasure : TreasureRoute("treasure")
}

