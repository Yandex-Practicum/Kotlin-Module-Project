package menu

import entity.Archive
import entity.Note
import java.util.*

class NotesMenu(private val parentMenu: ArchiveMenu, private val elem: Archive): BaseMenu<Note>(elem.notes) {
    override fun chooseCreate() = CREATE

    override fun add(scanner: Scanner) {
        println(ENTER_NAME)
        val name = scanner.nextLine()
        if (name == ArchiveMenu.GO_BACK) {
            show()
            return
        }
        println(ENTER_CONTENT)
        val content = scanner.nextLine()
        elem.notes.add(Note(name,content))
        println(NOTE_CREATED)
    }

    override fun open(elem: Note) {
        println(CONTENT + elem.name)
        println(elem.content)
        show()
    }

    override fun goBack() {
        parentMenu.show()
    }

    companion object {
        const val CONTENT = "Содержание заметки "
        const val CREATE = "0. Чтобы создать заметку"
        const val ENTER_CONTENT = "Введите содержание записки:"
        const val ENTER_NAME = "Введите название название заметки или введите \"${ArchiveMenu.GO_BACK}\" для возвращения на предыдущий экран"
        const val NOTE_CREATED = "Записка создана"
    }
}