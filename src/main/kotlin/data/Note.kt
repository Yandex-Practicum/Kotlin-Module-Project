package data

import ConsoleUtils

data class Note(override var name: String) : Item<String>(name) {
    override fun showContent() {
        if (this == null) {
            ConsoleUtils.write("Не найдено такой заметки")
            return
        }
        if (this.content.isEmpty()) {
            ConsoleUtils.write("Заметка пустая")
            return
        }
        ConsoleUtils.write("Заметка $name")
        content.forEach { println(it) }
    }
}
