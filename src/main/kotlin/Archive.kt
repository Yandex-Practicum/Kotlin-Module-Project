import java.util.Scanner

data class Archive(
    val name: String,
    val dataList: MutableList<Note> = mutableListOf()
) {
    val archiveChoice: ArchiveChoice = ArchiveChoice(this)

    companion object {

        fun createArchive(scanner: Scanner): Archive {
            print("Введите название архива: ")
            val inputName: String = scanner.nextLine()
            if (inputName.isEmpty()) return Archive("Без названия")
            return Archive(inputName)
        }
    }

    fun addNote(scanner: Scanner): Boolean {
        val note = Note.createNote(scanner)
        dataList.add(note)
        archiveChoice.dataList.add(
            MenuData(note.name, action = { note.noteChoice.start(); true })
        )
        return true
    }
}

class ArchiveChoice(archive: Archive) : Menu() {
    override val title: String = "Архив '${archive.name}'. Список заметок"
    override val dataList: MutableList<MenuData> = mutableListOf(
        MenuData("Создать заметку", action = { archive.addNote(scanner) }),
        MenuData("Назад", action = { super.exit() })
    )
}