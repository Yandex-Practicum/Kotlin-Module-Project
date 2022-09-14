class PrintArhiv<T> (
    text: String,
    list: List<T>
) {
    init {
        startMain(text, list, null, null)
    }
}

class PrintNot<T> (
    text: String,
    list: List<T>,
    thisArhiv: Arhiv
) {
    init {
        startMain(text, list, thisArhiv, null)
    }
}

class PrintNotes<T> (
    note: Note,
    list: List<T>
) {
    init {
        startMain("text", list, null, note)
    }
}

