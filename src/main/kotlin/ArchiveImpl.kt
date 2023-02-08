import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle


class ArchiveImpl : InterfaceArchive {

    private var archiveMap: MutableMap<String, MutableList<String>> = mutableMapOf()
    private var noteList: MutableList<String> = mutableListOf()

    //создание архива
    override fun createArchive(titleArchive: String) {
        archiveMap[titleArchive] = mutableListOf()
        println("You have created an archive $archiveMap")
    }

    // удаление архива
    override fun removeArchive(titleArchive: String) {
        if (archiveMap.containsKey(titleArchive)) {
            archiveMap.remove(titleArchive)
            println("Вы удалили $titleArchive")
        } else {
            println("Archive does not exist")
        }
    }

    //добавление заметки в архив
    override fun addNoteToArchive(titleArchive: String) {
        if (archiveMap.containsKey(titleArchive)) {
            println("The note will be added to the archive $titleArchive")
            archiveMap[titleArchive] = noteList
            println(archiveMap)
        } else {
            println("This archive or note does not exist.")
        }
    }

    //удаление всех архивов
    override fun clearArchive() {
        archiveMap.clear()
        println(archiveMap)
    }

    //показать все архивы
    override fun printAllArchive() {
        if (archiveMap.isNotEmpty()) {
            for (item in archiveMap) {
                println(item)
            }
        } else {
            println("Archive is empty")
        }
    }

    //показать все заметки
    override fun printAllNote() {
        if (noteList.isNotEmpty()) {
            println(noteList)

        } else {
            println("Note is empty")
        }
    }

    //создание заметки
    override fun createNote(strNote: String) {
        println(strNote)
        noteList.add(strNote)

    }

    // удаление заметки
    override fun removeNote(titleArchive: String) {
        if (noteList.contains(titleArchive)) {
            noteList.remove(titleArchive)
        } else {
            println("This note does not exist")
        }
    }
}




