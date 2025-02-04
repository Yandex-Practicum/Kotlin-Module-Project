package Item

interface Item {
    val name: String
}

class Archive(
    override val name: String,
    val notes: MutableList<Note>
): Item