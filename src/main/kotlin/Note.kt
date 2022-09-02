data class Note (override val title: String, override val parent: MenuInterface) : MenuInterface {

    private val noteContent: MutableList<String> = mutableListOf()

    override fun getContent(userChoice: Int): String {
        return title
    }

    override fun addContent(title: String) {
        val nextKey = noteContent.size
        noteContent[nextKey] = title
    }

    override fun getPrevious(): MenuInterface {
        return parent
    }

    override fun getTitles(): MutableList<String> {
        return noteContent
    }
}
