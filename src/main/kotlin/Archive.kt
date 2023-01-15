class Archive (
    var title: String,
    var notesList: ArrayList<Note> = arrayListOf<Note>()
        ) {

    override fun toString(): String {
        return title
    }
}