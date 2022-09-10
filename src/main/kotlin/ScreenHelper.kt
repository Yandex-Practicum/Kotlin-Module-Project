import java.util.*
import kotlin.system.exitProcess


object ScreenHelper {
    private val scanner = Scanner(System.`in`)
    private val archives = mutableListOf<Archive>()

    fun showScreen(screen: Screen) {
        when (screen) {
            is Screen.ShowAllArchives -> {
                println("АРХИВЫ")
                println("0. Создать архив")
                printListInMenu(archives)
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
                println("АРХИВ ${screen.archive.name}")
                println("0. Создать заметку")
                printListInMenu(screen.archive.notes)
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
                println("ЗАМЕТКА ${screen.note.title}")
                println(screen.note.text)
                println("Любая клавиша - Выход")
                scanner.next()
                showScreen(Screen.ShowArchive(screen.note.archive))
            }

            is Screen.CreateArchive -> {
                print("Введите название архива: ")
                val archiveName = scanner.next()
                archives.add(Archive(archiveName))
                showScreen(Screen.ShowAllArchives)

            }
            is Screen.CreateNote -> {
                print("Введите заголовок заметки: ")
                val title = scanner.next()
                print("Введите текст заметки: ")
                val text = scanner.next()
                screen.archive.notes.add(Note(title, text, screen.archive))
                showScreen(Screen.ShowArchive(screen.archive))
            }
        }
    }

    private fun validateSymbolsInput() {
        while (!scanner.hasNextInt()) {
            println("Вы ввели не цифру! Введите цифру...")
            scanner.next()
        }
    }

    private fun navigateScreen(
        userNumber: Int,
        list: List<Any>,
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
        println("Число должно быть в пределах от 0 до ${maxSize + 1}")
    }

    private fun printListInMenu(list: List<PrintableName>) {
        var menuNumber = 1
        for (value in list) println("${menuNumber++}. ${value.getPrintableName()}")
        println("${menuNumber}. Выход")
    }
}

