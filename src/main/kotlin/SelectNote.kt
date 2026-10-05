class SelectNote(val noteList: MutableList<Note>) {
    fun watch() {
        if (noteList.isEmpty()) {
            println("Нет записок")
            return
        }
        val items = mutableListOf<Pair<String, () -> Unit>>()
        noteList.forEach { note ->
            items.add(note.name to { openNote(note) })
        }
        val nav = Navigation("Выберите записку:", items)
        items.add("Назад" to { nav.running = false })
        nav.watch()
    }
        fun openNote(note: Note) {
            println("Открыта записка: ${note.name}")
            NoteWatch(note).watch()
        }
}