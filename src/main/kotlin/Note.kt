data class Note(
    val title: String,
    val text: String,
    val archive: Archive
) : PrintableName {

    override fun getPrintableName(): String {
        return title
    }
}