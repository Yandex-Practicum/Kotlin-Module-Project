package AppState
import Menu
import Screen.Screen

// Singleton представляющий собой дерево экранов и предоставляющий функционал для выполнения действий над ними.

object AppState {
    val screenMap: Map<String, Screen> =mapOf(
        "choseArchive" to Screen(name = "choseArchive", menu = Menu.CHOSEARCHIVE),
        "createArchive" to Screen(name = "createArchive", menu = Menu.CREATEARCHIVE),
        "choseNote" to Screen(name = "choseNote", menu = Menu.CHOSENOTE),
        "createNote" to Screen(name = "createNote", menu = Menu.CREATENOTE),
        "noteView" to Screen(name = "noteView", menu = Menu.NOTEVIEW)
    )
    val keyPoint: String ="choseArchive"
    var locationInApp = keyPoint

    // Функция осуществляющая переход вниз по иерархии экранов.
    fun nextScreen(enteredCode: Int): String = when (locationInApp) {
        "choseArchive" -> if (enteredCode == 0) "createArchive" else "choseNote"
        "choseNote" -> if (enteredCode == 0) "createNote" else "noteView"
        else -> "Error"
    }

    // Функция осуществляющая переход вверх по иерархии экранов.
    fun previousScreen(enteredCode: Int): String = when (locationInApp) {
        "choseArchive" -> "Exit"
        "createArchive" -> "choseArchive"
        "choseNote" -> "choseArchive"
        "createNote" -> "choseNote"
        else -> "choseNote"
    }


    // Функция передающая экран с которым происходит взаимодействие на данный момент
    fun showScreen(): Screen ?= screenMap[locationInApp]



}