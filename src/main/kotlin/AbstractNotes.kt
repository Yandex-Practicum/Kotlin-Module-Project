abstract class AbstractNotes() {
    abstract val parent: AbstractNotes
    abstract val title: String
    fun getPrevious(): AbstractNotes {
        return parent
    }
}