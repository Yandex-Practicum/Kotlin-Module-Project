package views

import data.Archive
import java.util.Scanner

class ArchiveViewList(var archive: MutableList<Archive>) : View() {
    override var viewName = "Экран списка архивов"

    override fun showContent() {
        println(viewName)
        println("0. Перейти к экрану созданию нового архива")
        archive.forEachIndexed { index, archive -> println("${index + 1}. Перейти к архиву ${archive.name}") }
        println("${archive.size + 1}. Выход")
    }

    override fun readCommand(): Int {
        var number: Int?
        while (true) {
            println("Введите команду по номеру поля.")
            number = Scanner(System.`in`).nextLine().toIntOrNull()
            if (number !in 0..archive.size + 1) {
                println("Введен некорректный номер, ввидите цифру из списка.")
            } else {
                break
            }
        }
        return number!!
    }

    override fun commandReader() {
        while (!isEnd) {
            showContent()
            when (val command = readCommand()) {
                0 -> (ArchiveCreationView(archive).commandReader())
                archive.size + 1 -> exit()
                else -> NoteViewList(archive[command - 1].notesList).commandReader()
            }
        }
    }

    override fun exit() {
        println("Выходим из приложения.")
        archive.clear()
        isEnd = true
    }
}