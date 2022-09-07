import java.util.*

class PrintArchiveListUtils
    <T>(
    private val title: String,
    private val firstItemText: String,
    private val list: MutableList<T>
    ) {
    init {
        mainFunction(title, firstItemText, list, null, null)
    }
}