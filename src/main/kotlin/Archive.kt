class Archive: BaseStructure<String, Note>() {

    override var list: MutableMap<String, Note> = mutableMapOf()

    override fun showList() {
        println("\nСписок архивов:\n0. Создать архив")
        super.showList()
    }

    override fun addItem(key: String) {
        list[key] = Note()
    }


}