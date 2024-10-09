import menu.chooseNote
import menu.createArchive
import menu.createNote
import modules.Archive

import utils.showMenu
fun main(args: Array<String>) {
    val archives = mutableListOf<Archive>()
    var isRunnig = true
    while (isRunnig) {
        val mainMenuOptions = listOf("Создать архив", "Выбрать архив", "Выход")
        when(showMenu(mainMenuOptions, "Главное меню: ")) {
            1 -> createArchive(archives)
            2 -> {
                val selectedArchive = chooseArchive(archives)
                if (selectedArchive != null) {
                    var isRunningNoteMenu = true
                    while (isRunningNoteMenu) {
                        val noteMenuOption = listOf("Создать заметку", "Выбрать заметку", "Выход")
                        when(showMenu(noteMenuOption, "Меню заметок:")) {
                            1 -> createNote(selectedArchive)
                            2 -> chooseNote(selectedArchive)
                            3 -> isRunningNoteMenu = false
                            else -> println("Неверное значение")
                        }
                    }
                }
            }
            3 -> isRunnig = false
            else -> println("Неверное значение")        }
    }
    println("Завершение работы!")
}