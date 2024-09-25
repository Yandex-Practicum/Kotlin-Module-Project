class ArrayMenuAddNote: ArMenuExec {
    override fun execute(archive: Archive) {
        val noteName = getTextInput()
        val noteContent = getTextInput()
        archive.addNote(noteName, noteContent)
        println("Заметка успешно добавлена")
    }

    override fun addArchive(name: String) {

    }
}