import java.util.Scanner

class NoteCreate {
    fun createNote(list: MutableList<Note>) {
    println("Введите имя заметки:")
    val name = Scanner(System.`in`).nextLine()
    if (name.isBlank()) {
        println("Имя не может быть пустым")
        return
    }
        println("Введите текст записки:")
        val text = Scanner(System.`in`).nextLine()
        if (text.isBlank()) {
            println("Записка не может быть пустой")
            return
        }
    list.add(Note(name, text))}
}
