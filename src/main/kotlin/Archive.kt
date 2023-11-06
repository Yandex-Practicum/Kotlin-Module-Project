data class Archive(val notesList: List<Note>, val archiveName: String) {
    var count: Int = notesList.size
}