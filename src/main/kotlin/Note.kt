data class Note (val title: String, val parent: Notes) {
    var content: MutableList<String> = mutableListOf()

    fun getListOfContent(): MutableList<String> {
        return content
    }

    fun addContent(newString: String) {
        content.add(newString)
    }

}