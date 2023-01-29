package entity

data class Note(
    val name: String,
    val content: String
) {
    override fun toString(): String  ="Заметку $name"
}