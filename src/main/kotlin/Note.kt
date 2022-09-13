class Note(
    override var title: String,
    private var content: String,
    override val parent: Folder?
) : NavigatorItem {

    override val TYPE_I: String = "Заметка"
    override val TYPE_R: String = "заметки"
    override val TYPE_D: String = "заметкy"
    override val ENDING: String = "а"

    override fun toString(): String = title
    fun toContent(): String = content
    fun saveToContent(sample: String) {
        content = sample
    }
}