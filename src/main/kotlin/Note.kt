class Note(override var name: String, var text: String): Screen() {

    override fun showObjects() {
        println("--------------------")
        println("Название: $name")
        println("Текст: $text")
        println("--------------------")
    }
}