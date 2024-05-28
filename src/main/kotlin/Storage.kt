import java.util.Scanner

class Storage {

    private val archives    : MutableSet<String> = mutableSetOf()
    private val notes       : MutableMap<String, MutableList<String>> = mutableMapOf()

    var currentArchName : String = ""
    var currentNoteText : String = ""

    fun setCurrentArchive(name: String) {
        currentArchName = name
    }

    fun setCurrentNote(note: String) {
        currentNoteText = note
    }

    private fun createArchive(name: String) {
        archives.add(name)
        notes[name] = mutableListOf()
    }

    fun createArchive() {

        var arcName: String
        val scanner = Scanner(System.`in`)

        println("Введите имя нового архива")

        do {
            arcName = scanner.nextLine()

        } while(arcName.isBlank())

        createArchive(arcName)
    }

    fun getArchives(): List<String> {
        return archives.toList()
    }

    fun createNote() {

        var noteText: String

        val scanner = Scanner(System.`in`)

        println("Введите текст заметки:")
        do { noteText = scanner.nextLine() } while(noteText.isBlank())

        if(!notes.containsKey(currentArchName))
            notes[currentArchName] = mutableListOf()

        notes[currentArchName]!!.add(noteText)

    }

    fun getNotes(): List<String> {
        return notes.get(key=currentArchName)!!.toList()
    }


}