class NoteScreen(val noteList: MutableList<Note>) {
    fun watch() {
        val items = mutableListOf<Pair<String, () -> Unit>>()
        val nav = Navigation("Выберите действие", items)
        items.add("Создать заметку" to { NoteCreate().createNote(noteList) })
        items.add("Выбрать заметку" to { SelectNote(noteList).watch() })
        items.add("Выход" to { nav.running = false })
        nav.watch()
    }
}