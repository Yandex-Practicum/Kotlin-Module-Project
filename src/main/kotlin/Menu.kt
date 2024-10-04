import kotlin.system.exitProcess

abstract class Menu(
    private val menuItems: List<MenuItem> = listOf(),
) {
    fun switchCommands() {
            userInteraction.printMenu(menuItems)
            when (val command = userInteraction.readCommand()) {
                in menuItems.indices -> {
                    menuItems[command].command()
                }
                else -> {
                    userInteraction.incorrectInput(menuItems.size)
                    switchCommands()
                }
            }
    }

    private var userInteraction = UserInteraction()
}

class MenuItem(
    val title: String,
    val command: () -> Unit
)

class MenuItems(
    private var currentNote: Note? = null,
    private var currentArchive: Archive = Archive(),
    private val archives: Archives = Archives(),
) {
    private val noteMenuItems: List<MenuItem> = listOf(
        MenuItem("Add text") {
            currentNote?.inputText() ?: println("Note is not created")
            noteMenu.switchCommands()
        },
        MenuItem(
            "Exit to archive"
        ) {
            archiveMenu.switchCommands()
        }
    )

    private val mainMenuItems: List<MenuItem> = listOf(
        MenuItem(
            "Create archive"
        ) {
            archives.itemsList += (Archive().create())
            archiveMenu.switchCommands()
        },
        MenuItem(
            "Show archives"
        ) {
            archives.showArchives()
            archivesListMenu.switchCommands()
        },
        MenuItem(
            "Exit to desktop"
        ) {
            exitProcess(0)
        }
    )

    private val archiveMenuItems: List<MenuItem> = listOf(
        MenuItem(
            "Create note"
        ) {
            currentNote = Note().create()
            currentArchive.addNote(currentNote!!)
            noteMenu.switchCommands()
        },
        MenuItem(
            "Show notes"
        ) {
            currentArchive.showNotes()
            notesListMenu.switchCommands()
        },
        MenuItem(
            "Exit to archives list"
        ) {
            archivesListMenu.switchCommands()
        }
    )

    private val archivesListMenuItems: List<MenuItem> = listOf(
        MenuItem("Choose archive") {
            currentArchive = archives.choose()
            archiveMenu.switchCommands()
        },
        MenuItem("Exit to main menu") {
            mainMenu.switchCommands()
        }
    )


    private val notesListMenuItems: List<MenuItem> = listOf(
        MenuItem("Choose note") {
            currentNote = currentArchive.chooseNote()
            noteMenu.switchCommands()
        },
        MenuItem("Exit to archive menu") {
            archiveMenu.switchCommands()
        }
    )

    val mainMenu = MainMenu(mainMenuItems)

    private val archiveMenu = ArchiveMenu( archiveMenuItems)
    private val noteMenu = NoteMenu(noteMenuItems)
    private val notesListMenu = NotesListMenu( notesListMenuItems)
    private val archivesListMenu = ArchivesListMenu( archivesListMenuItems)
}

class ArchiveMenu(items: List<MenuItem>): Menu(items)

class MainMenu(items: List<MenuItem>) : Menu(items)

class NoteMenu(items: List<MenuItem>) : Menu(items)

class ArchivesListMenu(items: List<MenuItem>) : Menu(items)

class NotesListMenu(items: List<MenuItem>) : Menu(items)