class Note: BaseStructure<String, String>() {

    override var list: MutableMap<String, String> = mutableMapOf()

    override fun showList() {
        println("\nСписок заметок:\n0. Создать заметку")
        super.showList()
    }

    override fun addItem(key: String) {
        val x = key.substring(0, if (key.length > 7) 7 else key.length) + "..."
        list[x] = key
    }
}