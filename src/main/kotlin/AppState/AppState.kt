package AppState

import Screen.Screen

class AppState(val screenMap: Map<String, Screen>, val keyPoint: String) {
    var locationInApp = keyPoint

    fun nextScreen(enteredCode: Int): String = when (locationInApp) {
        "choseArchive" -> if (enteredCode == 0) "createArchive" else "choseNote"
        "choseNote" -> if (enteredCode == 0) "createNote" else "noteView"
        else -> "Error"
    }

    fun previousScreen(enteredCode: Int): String = when (locationInApp) {
        "choseArchive" -> "Exit"
        "createArchive" -> "choseArchive"
        "choseNote" -> "choseArchive"
        "createNote" -> "choseNote"
        "noteView" -> "choseNote"
        else -> "Error"
    }


    fun showScreen(): Screen ?= screenMap[locationInApp]


}