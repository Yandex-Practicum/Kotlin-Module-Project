class Folder(
    override var title: String,
    override val parent: Folder?
) : NavigatorItem {
    val items: MutableSet<NavigatorItem> = mutableSetOf()

    override val TYPE_I: String = "Архив"
    override val TYPE_R: String = "архива"
    override val TYPE_D: String = "архив"
    override val ENDING: String = ""

    override fun toString(): String = title
}