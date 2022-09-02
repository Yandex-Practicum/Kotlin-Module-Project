data class Note (override val title: String, override val parent: AbstractNotes): AbstractNotes()  {
//
//    private val noteContent: MutableList<String> = mutableListOf()
//
//    override fun getContent(userChoice: Int): String {
//        return title
//    }
//
//    override fun addContent(title: String) {}
//
//    override fun getPrevious(): MenuInterface {
//        return parent
//    }
//
//    override fun getTitles(): MutableList<String> {
//        return noteContent
//    }
}
