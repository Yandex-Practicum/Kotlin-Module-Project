data class Note (val title: String, val text: String) {
    override fun toString(): String {
        return title
    }

    fun printFullNote(): Unit {
        println(title)
        println("========")
        println(text)
    }
}