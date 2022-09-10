class Archive(
    val name: String
) : PrintableName {
    val notes = mutableListOf<Note>()

    override fun getPrintableName(): String {
        return name
    }
}