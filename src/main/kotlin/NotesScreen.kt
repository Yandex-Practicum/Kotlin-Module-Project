class NotesScreen {
    private val utils = Utils()

    fun run(position: Int) {
        val archive = RepositoryObject.repository[position - 1]

        while (true) {
            val notes = archive.notes
            val numberOfNotes = notes.size
            utils.showMenu(notes)
            val input = utils.readNumber(numberOfNotes)
            if (input == 0) {
                //ArchiveMakeScreen().addArchive()
            } else if (input == (numberOfNotes + 1)) {
                break
            } else {
                println("======")
                println("Имя заметки: ${notes[input].name}")
                println("Текст: ${notes[input].text}")
                println("======")
            }
        }
    }
}