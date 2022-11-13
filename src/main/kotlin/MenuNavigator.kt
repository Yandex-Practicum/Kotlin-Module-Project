import java.util.*
import kotlin.system.exitProcess

class MenuNavigator(private val archives: MutableList<Archive>) {

    fun demonstrateScreen(screen: Screen) {
        when (screen) {
            is Screen.AllArchives -> {
                printArchiveNavigation()
                printArchives(archives)
                when(val i = getUserInput()) {
                    0 -> exitProcess(0)
                    1 -> addNewArchive()
                    else -> openArchive(i)
                }
            }
            is Screen.ChosenArchive -> {
                printNotesNavigation(screen.archive.name)
                printNotes(screen.archive.notes)
                when(val i = getUserInput()) {
                    0 -> demonstrateScreen(Screen.AllArchives)
                    1 -> addNewNote(screen.archive)
                    else -> openNote(i, screen.archive)
                }
            }
            is Screen.ChosenNote -> {
                if(screen.note.content == "") {
                    println("Введите текст заметки")
                    screen.note.content = Scanner(System.`in`).nextLine()
                    demonstrateScreen(Screen.AllArchives)
                }
                else {
                    println(screen.note.content)
                    println("Введите '1', если хотите изменить текст заметки, введите любое другое число, чтобы вернуться в главное меню")
                    when(getUserInput()) {
                        1 -> {
                            println("Введите новый текст заметки")
                            screen.note.content = Scanner(System.`in`).nextLine()
                            demonstrateScreen(Screen.AllArchives)
                        }
                        else -> demonstrateScreen(Screen.AllArchives)
                    }
                }
            }
        }
    }

    private fun printArchiveNavigation() {
        println("Вы находитесь в меню создания нового или выбора имеющегося архива. " +
                "Введите '0' для выхода из программы, '1' для создания новго архива " +
                "или номер архива для чтения/добавления заметок.")
        println("0. Выход из программы")
        println("1. Создание нового архив")
    }


    private fun printArchives (listOfArchives: MutableList<Archive>) {
        for (item in listOfArchives) {
            println("${listOfArchives.indexOf(item) + NUMBER_OF_SYSTEM_ENTRIES}. ${item.name}")
        }
    }

    private fun addNewArchive() {
        println("Введите название архива")
        var name = Scanner(System.`in`).nextLine()
        while (name == "") {
            println("Введите непустую строку")
            name = Scanner(System.`in`).nextLine()
        }
        archives.add(Archive(name))
        demonstrateScreen(Screen.AllArchives)
    }

    private fun openArchive(userInput: Int) {
        var index = userInput - NUMBER_OF_SYSTEM_ENTRIES
        while (index >= archives.size) {
            println("Некорректный ввод. Введите число, соответствущее одному из пунктов меню.")
            demonstrateScreen(Screen.AllArchives)
            index = getUserInput()
        }
        demonstrateScreen(Screen.ChosenArchive(archives[index]))
    }

    private fun printNotesNavigation(archiveName: String) {
        println("Вы находитесь в меню выбора создания или изменения заметок в архиве $archiveName. " +
                "Введите '0' для возврата в меню выбора архива, '1' для создания новой заметки " +
                "или номер заметки, которую вы хотите прочитать или изменить.")
        println("0. Возврат в меню выбора архива")
        println("1. Создание новой заметки")
    }

    private fun printNotes (userItems: MutableList<Note>) {
        for (item in userItems) {
            println("${userItems.indexOf(item) + NUMBER_OF_SYSTEM_ENTRIES}. ${item.name}")
        }
    }

    private fun addNewNote(archive: Archive) {
        println("Введите название заметки")
        var name = Scanner(System.`in`).nextLine()
        while (name == "") {
            println("Введите непустое название")
            name = Scanner(System.`in`).nextLine()
        }
        archive.notes.add(Note(name))
        demonstrateScreen(Screen.ChosenArchive(archive))
    }

    private fun openNote(userInput: Int, archive: Archive) {
        var index = userInput - NUMBER_OF_SYSTEM_ENTRIES
        while (index >= archive.notes.size) {
            println("Некорректный ввод. Введите число, соответствущее одному из пунктов меню.")
            demonstrateScreen(Screen.ChosenArchive(archive))
            index = getUserInput()
        }
        demonstrateScreen(Screen.ChosenNote(archive.notes[index]))
    }

    private fun getUserInput(): Int {
        var i = Scanner(System.`in`).nextLine()
        while(true) {
            try {
                i.toInt()
                break
            } catch (e: NumberFormatException) {
                println("Некорректный ввод, ожидается число")
                i = Scanner(System.`in`).next()
                continue
            }
        }

        return i.toInt()
    }


    companion object {
        const val NUMBER_OF_SYSTEM_ENTRIES = 2
    }
}
