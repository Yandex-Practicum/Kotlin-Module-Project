package menu

import utils.ScanEnter
import datastructure.Container

internal class MenuNote(
    override val container: Container,
    override var menu: String = "* Заметки *",
    override val commands: MutableList<String> = mutableListOf()
) : AbstСonstructorMenu() {

    private var idArchive: Int? = null
    private var idNote: Int? = null

    internal fun run(archiveId: Int, noteId: Int) {

        this.idArchive = archiveId
        this.idNote = noteId

        println(LINE)
        commands.add("Назад")

        val note = container.getArch(idArchive!!).notesList[idNote!!]
        println(menu)

        println("Имя: ${note.nameNote} \n" + "Текст заметки: ${note.textNote}")

        commands.forEachIndexed { index, command ->
            println("$index. $command")
        }

        print("Введите пункт меню: ")
        validateCommand()
    }

    override fun validateCommand() {

        ScanEnter().validateInt(commands.size - 1)
        MenuArchive(container).run(idArchive!!)

    }
}