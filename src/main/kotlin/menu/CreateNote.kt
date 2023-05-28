package menu

import utils.ScanEnter
import datastructure.Container
import datastructure.Note

internal class CreateNote(
    override val container: Container,
    override var menu: String = "**** СОЗДАНИЕ ЗАМЕТКИ ****",
    override val commands: MutableList<String> = mutableListOf()
) : AbstСonstructorMenu() {

    private var idArchive: Int? = null

    private var name: String? = null
    private var content: String? = null

    internal fun run(archiveId: Int) {
        this.idArchive = archiveId

        println(LINE)

        print("Введите имя ЗАМЕТКИ: ")
        name = ScanEnter().validateString()
        updateData()

        print("Введите текст ЗАМЕТКИ: ")
        content = ScanEnter().validateString()
        updateData()

        commands.add("Назад в АРХИВ")

        commands.forEachIndexed { index, option ->
            println("$index. $option")
        }
        println("Выберите пункт меню: ")

        validateCommand()
    }

    override fun validateCommand() {
        while (true) {
            when (ScanEnter().validateInt(commands.size - 1)) {
                0 -> {
                    updateStorage()
                    MenuArchive(container).run(idArchive!!)
                    break
                }
            }
        }
    }

    private fun updateStorage() {
        container
            .getArch(idArchive!!)
            .notesList
            .add(
                Note(
                    nameNote = this.name!!,
                    textNote = this.content!!
                )
            )
    }

    private fun updateData() {
        println(
            "Заголовок: $name \n" +
                    "Содержимое: $content"
        )
    }
}