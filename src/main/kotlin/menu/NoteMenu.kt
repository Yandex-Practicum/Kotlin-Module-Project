package menu

import Exit
import File

class NoteMenu {
    companion object {
        internal var file = File("", "")
    }

    fun showMenu() {
        println("\nАрхив \"${FileMenu.folderName}\"\nЗаметка \"${file.name}\":")
        println(file.note)
        println("\n0. Выход")
        inputAndCheckCommand()
        Exit.status = Exit.FROM_NOTE_MENU
        Exit.executeExit()
    }

    private fun inputAndCheckCommand() {
        var restriction = true
        while (restriction) {
            print("> ")
            val input = readln()
            if (input.toIntOrNull() != 0) {
                println("Такого пункта нет\nВведите 0 для выхода")
            } else restriction = false
        }
    }

}