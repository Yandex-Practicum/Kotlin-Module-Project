package data

data class Archives(override var name: String) : Item<Archive>(name) {

    override fun showContent() {
        if (this.content.isEmpty()) {
            ConsoleUtils.write("Список архивов пуст")
            return
        }
        ConsoleUtils.write("Список архивов:")
        content.forEach { println(it.name) }
    }
}