import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

class ArchiveImpl : InterfaceArchive {

    private var archiveMap: MutableMap<String, MutableList<String>> = mutableMapOf()
    private var noteList: MutableList<String> = mutableListOf()


    override fun createArchive(titleArchive: String) {
        archiveMap[titleArchive] = mutableListOf()
        println("Вы создали архив $archiveMap")
    }

    override fun removeArchive(titleArchive: String) {
        if (archiveMap.containsKey(titleArchive)) {
            archiveMap.remove(titleArchive)
            println("Вы удалили $archiveMap")
            println("Archive deleted")
        } else {
            println("Archive does not exist")
        }
    }

    override fun addNoteToArchive(titleArchive: String, note: String) {
        if (archiveMap.containsKey(titleArchive)) {
            println("Найден архив $titleArchive")
            noteList.add(note)
            archiveMap[titleArchive] = noteList
            noteList.remove(note)
            println(noteList)
        } else {
            println("This archive or note does not exist.")
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
        if (noteList.isNotEmpty()) {
            println(noteList)
        } else {
            println("Note is empty")
        }
    }

    override fun viewNote(titleArchive: String) {
        return println(archiveMap.getValue(titleArchive))
    }

    override fun createNote(strNote: String) {
        val date = LocalDate.now()
            .format(
                DateTimeFormatter
                    .ofLocalizedDate(FormatStyle.SHORT)
            )
        noteList.add("Note creation date $date: $strNote")
        println("Note creation date $date: $strNote")
    }

    override fun removeNote(strNote: String) {
        if (noteList.contains(strNote)) {
            val remNote = noteList.indexOf(strNote)
            noteList.removeAt(remNote)
            println(noteList)
        } else {
            println("This note does not exist")
        }
    }
}



