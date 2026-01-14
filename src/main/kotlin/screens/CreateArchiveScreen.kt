package screens

import model.Archive
import storage.Storage
import java.util.Scanner

class CreateArchiveScreen {
    private val scanner = Scanner(System.`in`)

    fun show() {
        print("Введите имя архива: ")
        val name = scanner.nextLine()

        if (name.isBlank()) {
            println("Имя архива не может быть пустым")
            return
        }

        Storage.archives.add(Archive(name))
        println("Архив создан")
    }
}
