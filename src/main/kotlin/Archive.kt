import java.util.*


class Archive(
    var name :String,
    private var notes: MutableList<Note> = mutableListOf()
) {
    fun showArchive(){
        println("Архив $name")
        println("0. Создать заметку")
        notes.forEachIndexed { index, Note -> println("${index + 1}. ${Note.name}") }
        println("${notes.size + 1}. Выход")
        noteLogic(getCommand())
    }
    private fun createNote() {
        println("Как назовем новую заметку?")
        val nameNote = Scanner(System.`in`).nextLine()
        println("Введите содержание заметки")
        val contentNote = Scanner(System.`in`).nextLine()
        notes.add(Note(nameNote, contentNote ))
        println("Создана новая заметка с именем $nameNote")
        showArchive()
    }
    private fun openNote(note: Note) {
        note.showContent()
        showArchive()
    }
    private fun checkNumber(string:String): Boolean {
        return try {
            string.toInt()
            false
        } catch (e: NumberFormatException) {
            true
        }
    }
    private fun getCommand(): Int {
        var number: String = Scanner(System.`in`).nextLine()
        while (true)
            number = if (checkNumber(number)) {
                println("Неправильный ввод, Вы ввели символ или слово. Нужно ввести цифру")
                Scanner(System.`in`).nextLine()
            } else if ((number.toInt() > (notes.size + 1)) or (number.toInt() < 0)) {
                println("Неправильный ввод, такого пункта нет в меню")
                Scanner(System.`in`).nextLine()
            } else return number.toInt()
    }
    private fun noteLogic(number: Int) {
        when (number) {
            0 -> {
                createNote()
            }
            (notes.size + 1) -> {
                return
            }
            else -> {
                openNote(notes[number-1])
            }
                    }

    }
}