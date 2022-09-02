class ArchiveOfNotes(override val title: String, override val parent: AbstractNotes) :
    AbstractNotes(), MenuInterface<Note> {

    override val contentList: MutableList<Note> = mutableListOf()

    override fun addContent(title: String) {
        contentList.add(Note(title, this))
    }

    override fun getContent(userChoice: Int): Note {
        return contentList[userChoice - 1]
    }
}
