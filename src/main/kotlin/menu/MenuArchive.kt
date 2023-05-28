package menu

import utils.ScanEnter
import datastructure.Container
import datastructure.Archive

internal class MenuArchive(
    override var container: Container,
    override var menu: String = "* Заметки |%s| *",
    override val commands: MutableList<String> = mutableListOf()
) : AbstСonstructorMenu() {


    private var archive: Archive? = null
    private var idArchive: Int? = null


    internal fun run(archiveId: Int) {

        this.idArchive = archiveId
        this.archive = container.getArch(archiveId)

        println(LINE)

        menu = String.format(menu, archive!!.nameArchive)
        commands.add("Создать ЗАМЕТКУ")
        archive!!.notesList.forEach { note ->
            commands.add(note.nameNote)
        }

        commands.add("Назад")
        menuСonstructor()
        validateCommand()
    }

    override fun validateCommand() {

        when (val command = ScanEnter().validateInt(commands.size - 1)) {
            0 -> CreateNote(container).run(idArchive!!)
            commands.size - 1 -> SelectArch(container).run()
            else -> MenuNote(container).run(idArchive!!, command - 1)

        }
    }
}