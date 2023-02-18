import java.util.Scanner

data class Note(
    val name: String,
    val value: String? = null
) {
    val noteChoice: NoteChoice = NoteChoice(this)

    companion object {

        fun createNote(scanner: Scanner): Note {
            print("Введите название заметки: ")
            val inputName: String = scanner.nextLine()
            print("Введите содержание заметки: ")
            val inputValue: String = scanner.nextLine()
            if (inputName.isEmpty()) return Note("Без названия")
            return Note(inputName, inputValue)
        }
    }

    override fun toString(): String {
        return "Название заметки: $name\nТекст: $value"
    }
}

class NoteChoice(note: Note) : Menu() {
    override val title: String = "Заметка '${note.name}'"
    override val dataList: MutableList<MenuData> = mutableListOf(
        MenuData("Открыть заметку", action = { println(note); true }),
        MenuData("Назад", action = { exit() })
    )
}