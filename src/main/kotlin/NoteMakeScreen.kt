class NoteMakeScreen {
    private val utils = Utils()

    fun addNote(archiveIndex: Int) {
        val archives = RepositoryObject.getArchives()
        val chosenArchive = archives[archiveIndex]

        println("======")
        println("Введите название заметки:")
        val name = utils.readString()
        println("Введите текст заметки:")
        val text = utils.readString()
        chosenArchive.notes.add(NoteEntity(name, text))
    }
}