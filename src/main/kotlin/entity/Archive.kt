package entity

data class Archive(
    val name: String,
    val notes: ArrayList<Note>
) {
    override fun toString(): String  ="Архив $name"
}