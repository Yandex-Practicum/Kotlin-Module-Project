data class Note (
    val title: String,
    val text: String,
    val archive: Archives
): GivingName {
    override fun giveName(): String {
        return title
    }}