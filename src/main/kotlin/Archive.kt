data class Archive(val notesList: List<Note>, val title: String) {
    var count: Int = notesList.size
}