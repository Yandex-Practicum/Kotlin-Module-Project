data class Note (val title: String, val parent: Notes) : Notes {
    var content: MutableList<String> = mutableListOf()

    override fun getListOfContent(): MutableList<String> {
        return content
    }

    fun addContent(newString: String) {
        content.add(newString)
    }

}