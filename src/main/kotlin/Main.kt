import Screen.Screen
import AppState.AppState
import java.util.Scanner

fun main() {

    val appScreens: AppState =
        AppState(screenMap = mapOf(
            "choseArchive" to Screen(name = "choseArchive", menu = Menu.CHOSEARCHIVE),
            "createArchive" to Screen(name = "createArchive", menu = Menu.CREATEARCHIVE),
            "choseNote" to Screen(name = "choseNote", menu = Menu.CHOSENOTE),
            "createNote" to Screen(name = "createNote", menu = Menu.CREATENOTE),
            "noteView" to Screen(name = "noteView", menu = Menu.NOTEVIEW)
        ), keyPoint = "choseArchive")

    while (true) {

        appScreens.showScreen()?.showMenu()

        appScreens.nextScreen(0)
        appScreens.showScreen()?.showMenu()

        var scanner = Scanner(System.`in`).nextLine()

        if (scanner == "0") {break}

    }
   // screenList.onEach { it.showMenu() }

}
