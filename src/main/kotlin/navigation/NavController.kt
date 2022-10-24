package navigation

import archives.screens.ArchivesScreen
import archives.screens.CreateArchiveScreen
import core.screens.Screen
import notes.screens.CreateNoteScreen
import notes.screens.NoteScreen
import notes.screens.NotesListScreen

class NavController {
    private val transactions: MutableList<Screen> = mutableListOf()

    fun goTo(screen: Screens) {
        when (screen) {
            is Screens.NotesList -> {
                addScreen(NotesListScreen(screen.archiveId))
            }
            is Screens.Note -> {
                addScreen(NoteScreen(screen.id))
            }
            is Screens.ArchivesList -> {
                addScreen(ArchivesScreen())
            }
            is Screens.CreateArchive -> {
                addScreen(CreateArchiveScreen())
            }
            is Screens.CreateNote -> {
                addScreen(CreateNoteScreen(screen.archiveId))
            }
        }
    }

    fun popUp() {
        transactions.removeLast()
        val currentScreen = transactions.lastOrNull()
        if (currentScreen == null) {
            println(EXIT_TEXT)
            return
        } else {
            currentScreen.init()
        }
    }

    private fun addScreen(screen: Screen) {
        transactions.add(screen)
        screen.init()
    }

    companion object {
        const val EXIT_TEXT = "Всем пока и спасибо за рыбу"

        private var navController: NavController? = null

        fun getInstance(): NavController {
            return synchronized(this) {
                val instance = navController
                if (instance != null) {
                    instance
                } else {
                    val created = NavController()
                    navController = created
                    created
                }
            }
        }
    }
}
