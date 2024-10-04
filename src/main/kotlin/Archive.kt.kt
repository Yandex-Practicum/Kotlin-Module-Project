class Archive(
    override var name: String? = ""
) : Item(name) {
    private var notes: Notes = Notes()

    fun addNote(note: Note) {
        notes.itemsList.plus(note)
        println("Note added")
    }

    override fun create(): Archive {
        println("Enter archive name")
        name = readlnOrNull() ?: ""
        println("Archive created")
        return this
    }

    override fun show() {
        if (notes.itemsList.isEmpty()) {
            println("Notes list is empty")
        } else {
            for (i in notes.itemsList.indices) {
                println("$i. ${notes.itemsList[i].name}")
            }
            println("Notes shown")
        }
    }

    fun showNotes() {
        notes.show()
    }

    fun chooseNote(): Note {
        return notes.choose()
    }
}