class Note(private val nameNote: String, private val content: String, val arc: Archive) :
    Common(name = nameNote) {

    fun showData() {
        println("Заметка '$nameNote', ее текст: '$content'")
    }
}