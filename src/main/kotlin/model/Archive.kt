package model

data class Archive (val id: Int, val name: String) {
    override fun toString(): String = "Архив \"$name\""
}