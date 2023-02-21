data class Note(val textOfNote: String = " ") {
    val name: String
        get() = (if (textOfNote.length > 10)
            textOfNote.substring(startIndex = 0, endIndex = 10)
            else
            textOfNote
        )
}