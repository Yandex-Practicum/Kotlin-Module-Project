package model

class MenuItem(val number: Int, private val text: String, val operation: (() -> Unit)?) {
    override fun toString(): String {
        return "$number - $text"
    }
}