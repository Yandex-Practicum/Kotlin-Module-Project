import java.util.*

class Note(val name: String, val text: String) {
    companion object{
        fun create(): Note {
            println("Давайте создадим заметку\nВведи имя заметки!")
            val name = Scanner(System.`in`).nextLine()
            println("Введите текст! Срочно!")
            val text = Scanner(System.`in`).nextLine()
            val note = Note(name, text)
            println("Создана заметка: ${note.name}")
            return note

        }
    }
}
