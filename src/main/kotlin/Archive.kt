class Archive (
    var title: String,
    var notesList: ArrayList<Notes> = arrayListOf<Notes>()
) {

    override fun toString(): String {
        return title
    }
}