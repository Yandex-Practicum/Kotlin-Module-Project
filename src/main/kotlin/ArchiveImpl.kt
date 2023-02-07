import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

class ArchiveImpl : InterfaceArchive {

    private var archiveMap: MutableMap<String, MutableList<String>> = mutableMapOf()


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

    override fun addNoteToArchive(titleArchive: String, note: MutableList<String>) {
        if (archiveMap.containsKey(titleArchive)) {
            archiveMap[titleArchive] = note
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

    override fun viewNote(titleArchive: String) {
        return println(archiveMap.getValue(titleArchive))
    }

    override fun createNote(strNote: String): MutableList<String> {
        val date = LocalDate.now()
            .format(DateTimeFormatter
                .ofLocalizedDate(FormatStyle.SHORT))
        return mutableListOf("Note creation date $date: $strNote")

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



