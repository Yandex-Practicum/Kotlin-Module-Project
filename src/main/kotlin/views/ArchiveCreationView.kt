package views

import data.Archive
import java.util.*

class ArchiveCreationView(private val archiveList : MutableList<Archive>): View() {
    override var viewName = "Экран создания архива"
    override var navigateText = "Возвращаемся к экрану списка архивов."
    override var commandNumbers = archiveList.size + 1

    private fun createArchive(): () -> Unit = {
        lateinit var archive: Archive
        println("Введите название архива:")
        val archiveName = Scanner(System.`in`).nextLine()
        if (archiveName is String) {
            archive = Archive(archiveName)
        }
        println("Архив $archiveName успешно создан.")
        archiveList.add(archive)
    }

    override fun createCommands(): MutableList<Pair<String, () -> Unit>> {
        val commandList = mutableListOf<Pair<String, () -> Unit>>()
        commandList.add(
            Pair("0. Создать новый архив", createArchive()))
        commandList.add(Pair("1. Вернуться к экрану списка архивов.", exit()))
        return commandList
    }
}