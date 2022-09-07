class PrintNoteListUtils
    <T>(
    title: String,
    firstItemText: String,
    list: List<T>,
    currentArchive: Archive
    ) {
    init {
        mainFunction(title, firstItemText, list, currentArchive, null)
    }
}