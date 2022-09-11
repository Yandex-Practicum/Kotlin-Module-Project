data class Note(
    val title: String,
    val text: String,
    val archive: Arch
) : PrintableName {

    override fun getPrintableName(): String {
        return title
    }
}