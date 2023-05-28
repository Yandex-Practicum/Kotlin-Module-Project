package menu

import Exit
import File
import Lost
import java.lang.StringBuilder

class FileMenu : AbstractMenu() {
    companion object {
        internal var folderName = ""
    }

    private var listOfFiles = listOf<File>()

    override fun inputAndCheckCommand(): String {
        var input = ""
        var restriction = true
        while (restriction) {
            print("> ")
            input = readln()
            if (input.toIntOrNull() !in 0..listOfFiles.lastIndex + 2) {
                println("Такого пункта нет\nВведите число от 0 до ${listOfFiles.lastIndex + 2}")
            } else restriction = false
        }
        return input.trim()
    }

    private fun inputNote(): String {
        val note = StringBuilder()
        var restriction = true
        while (restriction) {
            val input = readln()
            if (note.isEmpty() && input.isEmpty()) {
                println("Заметка должна содержать минимум один символ")
                print("> ")
            } else if (input.isNotEmpty()) note.append("$input\n")
            else restriction = false
        }
        note.deleteCharAt(note.lastIndex)
        return note.toString()
    }

    override fun createNewOne() {
        println("\nВведите название заметки:")
        val newFileName = checkName()
        println("\nЗапишите заметку:\n(для завершения ввода введите пустую строку)")
        print("> ")
        val note = inputNote()
        var newFile = File(newFileName, note)

        if (newFileName == "4 8 15 16 23 42" && folderName == "Lost") newFile =
            File(newFileName, Lost().song)

        FolderMenu.archive.forEach { if (it.name == folderName) it.listOfFiles.add(newFile) }
        showMenu()
    }

    override fun showMenu() {
        FolderMenu.archive.forEach { if (it.name == folderName) listOfFiles = it.listOfFiles }
        println("\nАрхив \"$folderName\"\nСписок заметок :")
        val menuList = mutableMapOf("0. Создать заметку" to { createNewOne() })
        for (i in listOfFiles.indices) {
            menuList["${i + 1}. ${listOfFiles[i].name}"] = {
                Exit.status = Exit.FROM_NOTE_MENU
                NoteMenu.file = listOfFiles[i]
                NoteMenu().showMenu()
            }
        }
        menuList["${menuList.size}. Выход"] = {
            Exit.status = Exit.FROM_FILE_MENU
            Exit.executeExit()
        }
        menuList.forEach { println(it.key) }
        println("\nВведите число от 0 до ${listOfFiles.lastIndex + 2}")
        val input = inputAndCheckCommand()
        val selectedOption = menuList.keys.find { it.startsWith(input) }
        menuList[selectedOption]?.invoke()
    }

    override fun checkName(): String {
        var newFileName = ""
        var restriction = true
        while (restriction) {
            print("> ")
            newFileName = readln()
            val isEmpty = newFileName.trim().isEmpty()
            var notUnique = false
            for (i in FolderMenu.archive) {
                if (i.name == folderName) {
                    for (j in i.listOfFiles) {
                        if (j.name == newFileName) notUnique = true
                    }
                }
            }
            if (isEmpty) {
                println(
                    "Название должно содержать минимум один символ\n" +
                            "Введите название заметки:"
                )
            } else if (notUnique) {
                println(
                    "Заметки с таким названием уже существует\n" +
                            "Введите другое название заметки:"
                )
            } else restriction = false
        }
        return newFileName
    }

}