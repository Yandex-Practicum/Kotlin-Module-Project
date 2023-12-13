class Archive (
        val name : String
) {
    val listOfNotes: MutableMap<Int, Note> = mutableMapOf()

    fun showListOfNotes(){
        println("Список заметок:\n0. Создать")
        for ((key, value) in listOfNotes) {
            println("$key. ${value.name}")
        }
        println("${listOfNotes.size + 1}. Выйти")
    }

}