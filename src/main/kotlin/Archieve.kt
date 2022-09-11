data class Archieve(private var nameOfArch: String) {
    private val notes = mutableListOf<Note>()
    override fun toString(): String {
        return nameOfArch
    }

    fun addNotes (){
        println("Введите текст заметки:")
        var textNote = scanner.nextLine()

        notes.add(Note(textNote))
    }

    fun printNotes(): List<Note> {
        return notes
    }
}