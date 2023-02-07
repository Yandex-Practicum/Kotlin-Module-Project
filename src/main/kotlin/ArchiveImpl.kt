import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

class ArchiveImpl : InterfaceArchive {

    private var archiveMap: MutableMap<String, MutableList<String>> = mutableMapOf()
    private var noteList:MutableList<String> = mutableListOf()


    override fun createArchive(titleArchive: String) {
        archiveMap[titleArchive] = mutableListOf()
        println(archiveMap)
    }

    override fun removeArchive(titleArchive: String) {
        if (archiveMap.containsKey(titleArchive)) {
            archiveMap.remove(titleArchive)
            println(archiveMap)
            println("Archive deleted")
        } else {
            println("Archive does not exist")
        }
    }

    override fun addNoteToArchive(titleArchive: String, note: String) {
        if (archiveMap.containsKey(titleArchive)) {
            noteList.add(note)
            archiveMap[titleArchive] = noteList
            println(archiveMap)
        } else {
            println("This archive does not exist.")
        }
    }

    override fun clearArchive() {
        archiveMap.clear()
        println(archiveMap)
    }

    override fun printAllArchive() {
        if (archiveMap.isNotEmpty()) {
            println(archiveMap)
        } else {
            println("Archive is empty")
        }
    }

    override fun printAllNote() {
        println(noteList)
    }

    override fun viewNote(titleArchive: String) {
        return println(archiveMap.getValue(titleArchive))
    }

    override fun createNote(strNote: String): String {
        val date = LocalDate.now()
            .format(DateTimeFormatter
                .ofLocalizedDate(FormatStyle.SHORT))
        noteList.add("Note creation date $date: $strNote")
        return "Note creation date $date: $strNote"
    }

    override fun removeNote(titleArchive: String) {
        if (archiveMap.containsKey(titleArchive)) {
            archiveMap[titleArchive] = mutableListOf()
            println(archiveMap)
        } else {
            println("This note does not exist")
        }
    }
}



