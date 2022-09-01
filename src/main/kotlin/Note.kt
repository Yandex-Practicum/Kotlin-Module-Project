data class Note (override val title: String, override val parent: MenuInterface): MenuInterface {
    override val contentList: MutableList<out MenuInterface> = mutableListOf()
    override fun addContent(title: String) {
        println("Can't edit Note after creation")
    }
}
