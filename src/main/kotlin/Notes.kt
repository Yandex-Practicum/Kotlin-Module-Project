class Notes (
    var title: String,
    var description: String
) {

    override fun toString(): String {
        val result = "$title\n$description\n"
        return result
    }

}