import java.time.LocalDate

class Archive() : Note(), InterfaceArchive {

    private val note = Note()
    private var archiveMap: MutableMap<String, MutableList<String>> = mutableMapOf()

    override fun create(titleArchive: String, strNote: String) {
        val localDate = LocalDate.now().toString()
        archiveMap["Archive name: $titleArchive" +
                ". Date of creation: $localDate"] = note.createNote(strNote)
        println(archiveMap)
    }

    override fun removeArchive(titleArchive: String) {
        if(archiveMap.containsKey(titleArchive)) {
            archiveMap.remove(titleArchive)
        }
        println(archiveMap)
    }

    override fun replaceArchive(
        archiveKey: String,
        newNote: String
    ): MutableMap<String, MutableList<String>> {
        if (archiveMap.contains(archiveKey)) {
            val oldValue = archiveMap.getValue(archiveKey)
            removeArchive(archiveKey)
            val newList = note.createNote(newNote)
            archiveMap.put(archiveKey, newList)
        }
        return archiveMap
    }

    override fun clearArchive() {
        archiveMap.clear()
        println(archiveMap)
    }

    override fun printAllArchive() {
        println()
    }

}





