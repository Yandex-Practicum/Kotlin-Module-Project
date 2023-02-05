import java.time.LocalDate

class Archive() : Note(), InterfaceArchive {

    private val note = Note()
    private var archiveMap: MutableMap<String, MutableList<String>> = mutableMapOf()

    override fun create(titleArchive: String, strNote: String) {
        archiveMap[titleArchive] = note.createNote(strNote)
        println(archiveMap)
    }

    override fun removeArchive(titleArchive: String){
         if(archiveMap.containsKey(titleArchive)) {
            archiveMap.remove(titleArchive)
            println("Archive deleted")
        } else {
            println("Archive does not exist")
        }
    }

    override fun replaceArchive(archiveKey: String, newNote: String) {

    }


    override fun clearArchive() {
        archiveMap.clear()
        println(archiveMap)
    }

    override fun printAllArchive() {
        println()
    }

}





