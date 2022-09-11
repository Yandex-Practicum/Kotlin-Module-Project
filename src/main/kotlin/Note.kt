data class Note(val textNote: String) {
    override fun toString(): String {
        return textNote
    }

    fun printNote (): Unit {
        println("Текст заметки следующий: $textNote")
    }
}