class Archive (
    private val name: String,
    var noteList: MutableList<Note> = mutableListOf()
)
{
    override fun toString(): String {
        return this.name
    }
}