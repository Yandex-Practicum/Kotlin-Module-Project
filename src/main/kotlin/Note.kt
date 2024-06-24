open class Note(val name: String, val info:String) {

    override fun toString(): String {

        return name
    }
    fun infoOut(): String {

        return "СОДЕРЖИМОЕ ЗАМЕТКИ с названием: $name\n$info"
    }
}
