class PrintNoteListUtils
    <T>(
    private val title: String,
    private val firstItemText: String,
    private val list: MutableList<T>,
    private val currentArchive: Archive
    ) {
    init {
        mainFunction(title, firstItemText, list, currentArchive, null)
    }
}