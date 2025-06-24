package model

data class Note(
    var title: String,
    var body: String
) {

    override fun toString(): String {
        return title
    }
}