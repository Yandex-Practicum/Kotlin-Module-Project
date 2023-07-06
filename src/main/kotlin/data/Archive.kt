package data

data class Archive(override var name: String) : Item<Note>(name) {

    override fun showContent() {
        if (this == null) {
            ConsoleUtils.write("Не найдено такого архива")
            return
        }
        if (this.content.isEmpty()) {
            ConsoleUtils.write("Архив пустой")
            return
        }
        ConsoleUtils.write("Архив $name")
        content.forEach { println(it.name) }
    }
}
