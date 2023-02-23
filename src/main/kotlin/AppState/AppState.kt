package AppState

import ArchiveCollection.ArchiveCollection
import Menu
import Screen.Screen
import java.util.*

// Singleton вляющийся деревом экранов и предоставляющий функционал для выполнения действий над ними.

object AppState {
    val screenMap: Map<String, Screen> = mapOf(
        "choseArchive" to Screen(name = "choseArchive", menu = Menu.CHOSEARCHIVE),
        "createArchive" to Screen(name = "createArchive", menu = Menu.CREATEARCHIVE),
        "choseNote" to Screen(name = "choseNote", menu = Menu.CHOSENOTE),
        "createNote" to Screen(name = "createNote", menu = Menu.CREATENOTE),
        "noteView" to Screen(name = "noteView", menu = Menu.NOTEVIEW)
    )
    private const val keyPoint: String = "choseArchive"
    var locationInApp = keyPoint

    // Функция осуществляющая переход вниз по иерархии экранов.
    fun movement(massage: String): Int {

        when (massage) {
            "0" -> locationInApp = when (locationInApp) {
                "choseArchive" -> "createArchive"
                "createArchive" -> "choseArchive"
                "choseNote" -> "createNote"
                "createNote" -> "choseNote"
                "noteView" -> "choseNote"
                else -> return 400
            }
            "1" -> locationInApp = when (locationInApp) {
                "choseArchive","choseNote" -> ArchiveCollection.activityChose(screenMap[locationInApp]!!)
                else -> return 400
            }
            "2" -> locationInApp = when (locationInApp) {
                "choseArchive" -> "Exit"
                "choseNote" -> "choseArchive"
                else -> return 400
            }
            else -> locationInApp = when (locationInApp) {
                "createArchive", "createNote" -> ArchiveCollection.activityCreate(massage= massage, screen = screenMap[locationInApp]!!)
                 else -> return 400
            }

        }

        return 200
    }


    // Функция передающая экран с которым происходит взаимодействие на данный момент
    fun showScreen() = screenMap[locationInApp]?.showMenu()
    fun readText(): String = Scanner(System.`in`).nextLine()

}