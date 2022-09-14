import java.sql.DriverManager.println

data class Arhiv(private var nameOfArch: String) {
    private val notes = mutableListOf<Note>()
    override fun toString(): String {
        return nameOfArch
    }

    fun addNotes (){
        println("Введите текст заметки:")
        val textNote = scanner.nextLine()

        notes.add(Note(textNote))
    }

    fun getNotes(): List<Note> {
        return notes
    }
}