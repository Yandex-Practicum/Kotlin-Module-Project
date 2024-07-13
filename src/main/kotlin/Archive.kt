

open class Archive: WarningsText(), ExitAndWarningFlag {
    var archiveName: String = ""
        private set
    var archiveNotes: ArrayList<Note> = ArrayList()
        private set

    override fun getExitNum(): Int {
        return if (archiveNotes.isEmpty()) 1 else archiveNotes.size+1
    }

    override fun checkNum(num: Int): Boolean {
        return archiveNotes.indices.map { it -> it+1 }.contains(num)
    }

    fun createArchive(name: String): Boolean {
        if (name.isBlank()) {
            archiveNameError()
            return false
        }
        else {
            archiveName=name
            return true
        }
    }

    fun addNote(note: Note) {
        archiveNotes.add(note)
    }

    fun getNote(ind: Int): Note {
        return archiveNotes.get(ind-1)
    }

}