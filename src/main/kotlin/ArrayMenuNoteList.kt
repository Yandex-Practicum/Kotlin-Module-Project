class ArrayMenuNoteList: ArMenuExec {
    override fun execute(archive: Archive) {
        for (note in archive.noteList) {
            println("Название: ${note.value?.getName()}")
        }
    }
}