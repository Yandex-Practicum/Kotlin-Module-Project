class Note(
    val name: String,
    val contain: String
) {

    fun showNote() {
        println("$name\n$contain")
    }
}