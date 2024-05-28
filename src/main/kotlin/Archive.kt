class Archive(
    val title : String,
) {
    val map : MutableMap<Int, Note> = mutableMapOf()
    fun archiveAddMap(key : Int, value : Note) {
        map[key] = value
    }
    fun getNot() {
        for (i in map) {
            println("Заметка ${i.key + 1} - ${i.value.title} ")
        }
    }
    fun getTitle() {
        for (i in map.values) {
            val title = i.title
            println("getTitle $title")
            println("размер ${map.values.size}")
        }
    }
}

data class Note(
    val title : String,
    val content : String,
)