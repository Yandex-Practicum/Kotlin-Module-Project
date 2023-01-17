import java.util.Scanner

class Screen : ScreenHandler() {

    private val archives: MutableList<Archive> = mutableListOf()
    var currentArchive: Int? = null
    var currentNote: Int? = null

    fun showScreen(screen: Screens) {

        when (screen) {
            Screens.ARCHIVE -> {
                printMenu("Имеющиеся архивы: \n0. Создать архив", archives)
                val input = inputCheck(archives, screen)
                navigation(input, archives.size + 1)
            }

            Screens.NOTES -> {
                val parent = Screens.ARCHIVE
                printMenu(
                    "Заметки в архиве: \n0. Создать заметку",
                    archives[currentArchive!! - 1].notes
                )
                val input = inputCheck(archives[currentArchive!! - 1].notes, screen)
                navigation(input, archives[currentArchive!! - 1].notes.size + 1, parent)
            }

            Screens.CREATE_ARCHIVE -> {
                println("Введите название архива:")
                val userInput = Scanner(System.`in`).nextLine()
                archives.add(Archive(userInput))
                println("Добавлен архив $userInput")
                showScreen(Screens.ARCHIVE)
            }

            Screens.CREATE_NOTE -> {
                println("Введите название заметки:")
                val noteName = Scanner(System.`in`).nextLine()
                println("Введите текст заметки:")
                val noteText = Scanner(System.`in`).nextLine()
                archives[currentArchive!! - 1].notes.add(Note(noteName, noteText))
                println("Заметка $noteName добавлена в архив.")
                showScreen(Screens.NOTES)
            }

            Screens.SHOW_NOTE -> openNote(screen)
        }
    }

    private fun openNote(screen: Screens) {
        val noteName = archives[currentArchive!! - 1].notes[currentNote!! - 1].name
        val noteText = archives[currentArchive!! - 1].notes[currentNote!! - 1].text
        println("Название: $noteName")
        println("Текст: $noteText")
        inputCheck(currentScreen = screen)
        showScreen(Screens.NOTES)
    }

    private fun navigation(input: Int, archiveSize: Int, parent: Screens? = null) {
        if (parent == null) {
            if (input == archiveSize) {
                exit()
            } else if (input == 0) {
                showScreen(Screens.CREATE_ARCHIVE)
            } else {
                currentArchive = input
                showScreen(Screens.NOTES)
            }
        } else {
            if (input == archiveSize) {
                showScreen(parent)
            } else if (input == 0) {
                showScreen(Screens.CREATE_NOTE)
            } else {
                currentNote = input
                showScreen(Screens.SHOW_NOTE)
            }
        }
    }
}