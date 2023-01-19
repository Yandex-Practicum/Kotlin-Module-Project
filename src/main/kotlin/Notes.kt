class Notes(
    var title: String,
    var description: String
) {

    override fun toString(): String {
        return "$title\n$description\n"
    }

}