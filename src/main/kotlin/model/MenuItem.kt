package model

class MenuItem(val number: Int, private val text: String, val operation: (() -> Unit)?) {
    override fun toString() = "$number - $text"
}