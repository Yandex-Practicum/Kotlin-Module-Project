import java.util.*
import kotlin.system.exitProcess

fun main() {
    ScreenNavigator().showScreen(Screen.ShowAllArchives)
}

class ScreenNavigator {
    private val scanner = Scanner(System.`in`)
    private val archives = mutableListOf<Archive>()

    fun showScreen(screen: Screen) {
        when (screen) {
            is Screen.ShowAllArchives -> {
                println(screen.MENU_TITLE)
                println(screen.MENU_BUTTON_0)
                printListInMenu(archives, screen.EXIT)
                validateSymbolsInput()
                val userValue: Int = scanner.nextInt()
                navigateScreen(
                    userValue, archives,
                    callbackIfZero = { showScreen(Screen.CreateArchive) },
                    callbackIfLast = { exitProcess(0) },
                    callbackIfListItem = { showScreen(Screen.ShowArchive(archives[it])) },
                    callbackIfError = { showScreen(Screen.ShowAllArchives) }
                )
            }
            is Screen.ShowArchive -> {
                println("${screen.MENU_TITLE} ${screen.archive.name}")
                println(screen.MENU_BUTTON_0)
                printListInMenu(screen.archive.notes, screen.EXIT)
                validateSymbolsInput()
                val userValue = scanner.nextInt()
                val notes = screen.archive.notes
                navigateScreen(
                    userValue, notes,
                    callbackIfZero = { showScreen(Screen.CreateNote(screen.archive)) },
                    callbackIfLast = { showScreen(Screen.ShowAllArchives) },
                    callbackIfListItem = { showScreen(Screen.ShowNote(notes[it])) },
                    callbackIfError = { showScreen(Screen.ShowArchive(screen.archive)) }
                )
            }
            is Screen.ShowNote -> {
                println("${screen.MENU_TITLE} ${screen.note.title}")
                println(screen.note.text)
                println("${screen.ANY_KEY} - ${screen.EXIT}")
                scanner.next()
                showScreen(Screen.ShowArchive(screen.note.archive))
            }

            is Screen.CreateArchive -> {
                println(screen.MENU_TITLE)
                println(screen.ENTER_NAME)
                val archiveName = scanner.next()
                archives.add(Archive(archiveName))
                showScreen(Screen.ShowAllArchives)

            }
            is Screen.CreateNote -> {
                println(screen.MENU_TITLE)
                print(screen.ENTER_NOTE_TITLE)
                val title = scanner.next()
                print(screen.ENTER_NOTE_TEXT)
                val text = scanner.next()
                screen.archive.notes.add(Note(title, text, screen.archive))
                showScreen(Screen.ShowArchive(screen.archive))
            }
        }
    }

    private fun validateSymbolsInput() {
        while (!scanner.hasNextInt()) {
            println(ERROR_MESSAGE_ENTER_DIGIT)
            scanner.next()
        }
    }

    private fun navigateScreen(
        userNumber: Int,
        list: List<*>,
        callbackIfZero: (() -> Unit),
        callbackIfListItem: (Int) -> Unit,
        callbackIfLast: () -> Unit,
        callbackIfError: () -> Unit
    ) {
        when (userNumber) {
            0 -> callbackIfZero()
            list.size + 1 -> callbackIfLast()
            in 1..(list.size) -> callbackIfListItem(userNumber - 1)
            else -> {
                showOutOfSizeError(list.size)
                callbackIfError()
            }
        }
    }

    private fun showOutOfSizeError(maxSize: Int) {
        println("$ERROR_MESSAGE_NUMBER_LIMITS ${maxSize + 1}")
    }

    private fun printListInMenu(list: List<PrintableName>, exitText: String) {
        list.forEachIndexed { index, value ->
            println("${index + 1}. ${value.getPrintableName()}")
        }
        println("${list.size + 1}. $exitText")
    }

    companion object {
        const val ERROR_MESSAGE_NUMBER_LIMITS = "Число должно быть в пределах от 0 до"
        const val ERROR_MESSAGE_ENTER_DIGIT = "Вы ввели не цифру! Введите цифру..."
    }
}

