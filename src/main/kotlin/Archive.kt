class Archive(val title: String, val notes: MutableList<Note> = mutableListOf()) {
    companion object{
        val archives = mutableListOf<Archive>()

    }
}