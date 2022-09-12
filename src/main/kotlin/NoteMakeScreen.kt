class NoteMakeScreen {
    private val utils = Utils()

    fun addNote(archiveIndex: Int) {
        val archive = RepositoryObject.repository[archiveIndex]

        println("======")
        println("Введите название заметки:")
        val name = utils.readString()
        println("Введите текст заметки:")
        val text = utils.readString()
        archive.notes.add(NoteEntity(name, text))
    }
}