import java.util.*
import kotlin.collections.ArrayList

class PrintNoteUtils
    <T>(
    private val note: Note,
    private val list: MutableList<T>,
    ) {
    init {
        mainFunction("title", "firstItemText", list, null, note)
    }
}