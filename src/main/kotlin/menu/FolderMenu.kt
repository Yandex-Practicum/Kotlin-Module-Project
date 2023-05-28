package menu

import Exit
import Folder

class FolderMenu : AbstractMenu() {

    companion object {
        internal val archive: MutableList<Folder> = mutableListOf()
        internal var folderName = ""
    }

    override fun inputAndCheckCommand(): String {
        var input = ""
        var restriction = true
        while (restriction) {
            print("> ")
            input = readln()
            if (input.toIntOrNull() !in 0..archive.lastIndex + 2) {
                println("Такого пункта нет\nВведите число от 0 до ${archive.lastIndex + 2}")
            } else restriction = false
        }
        return input.trim()
    }

    override fun createNewOne() {
        println("\nВведите название архива:")
        val newFolderName = checkName()
        val newArchive = Folder(newFolderName, mutableListOf())
        archive.add(newArchive)
        showMenu()
    }

    override fun showMenu() {
        println("\nСписок архивов:")
        val menuList = mutableMapOf("0. Создать архив" to { createNewOne() })
        for (i in archive.indices) {
            menuList["${i + 1}. ${archive[i].name}"] = {
                Exit.status = Exit.FROM_FILE_MENU
                folderName = archive[i].name
                FileMenu().showMenu()
            }
        }
        menuList["${menuList.size}. Выход"] = {
            Exit.status = Exit.FROM_FOLDER_MENU
            Exit.executeExit()
        }
        menuList.forEach { println(it.key) }
        println("\nВведите число от 0 до ${archive.lastIndex + 2}")
        val input = inputAndCheckCommand()
        val selectedOption = menuList.keys.find { it.startsWith(input) }
        menuList[selectedOption]?.invoke()
    }

    override fun checkName(): String {
        var newFolderName = ""
        var restriction = true
        while (restriction) {
            print("> ")
            newFolderName = readln()
            val isEmpty = newFolderName.trim().isEmpty()
            var notUnique = false
            for (i in archive) {
                if (i.name == newFolderName) notUnique = true
            }
            if (isEmpty) {
                println(
                    "Название должно содержать минимум один символ\n" +
                            "Введите название архива:"
                )
            } else if (notUnique) {
                println(
                    "Архив с таким названием уже существует\n" +
                            "Введите другое название архива:"
                )
            } else restriction = false
        }
        return newFolderName
    }
}