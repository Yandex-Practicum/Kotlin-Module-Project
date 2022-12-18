package views

import data.Archive
import java.util.*

class ArchiveCreationView(private val archiveList : MutableList<Archive>): View() {

    override var viewName = "Экран создания архива"

    private fun createArchive() {
        lateinit var archive: Archive
        println("Введите название архива:")
        val archiveName = Scanner(System.`in`).nextLine()
        if (archiveName is String) {
            archive = Archive(archiveName)
        }
        println("Архив $archiveName успешно создан.")
        archiveList.add(archive)
    }

    override fun showContent() {
        println(viewName)
        println("0. Создать новый архив")
        println("1. Вернуться к экрану списка архивов.")
    }

    override fun readCommand(): Int {
        var number: Int?
        while (true) {
            println("Введите команду по номеру поля.")
            number = Scanner(System.`in`).nextLine().toIntOrNull()
            if (number !in 0..archiveList.size + 1) {
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
            when (readCommand()) {
                0 -> createArchive()
                1 -> exit()
            }
        }
    }

    override fun exit() {
        println("Возвращаемся к экрану списка архивов.")
        isEnd = true
    }
}