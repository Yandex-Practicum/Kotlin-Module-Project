class ArchiveOfNotes (val title: String, val parent: Notes) : Notes {

    private val archiveOfNotes: MutableList<Note> = mutableListOf()

    override fun getListOfContent(): MutableList<String> {
        val list: MutableList<String> = mutableListOf()
        for(each in archiveOfNotes) {
            list.add(each.title)
        }
        return list
    }

    fun addContent(note : Note) {
        archiveOfNotes.add(note)
    }

}