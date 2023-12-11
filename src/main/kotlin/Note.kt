class Note(override val name: String, private var content: String) : Menu() {
    fun readNote() {
        println("===============\nСодержимое заметки с именем: $name")
        println("$content \n===============")
    }
}