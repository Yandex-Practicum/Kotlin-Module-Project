interface MenuInterface {
    abstract val parent: MenuInterface?
    abstract val title: String
    abstract val contentList: MutableList<out MenuInterface>
    abstract fun addContent(title: String)
}