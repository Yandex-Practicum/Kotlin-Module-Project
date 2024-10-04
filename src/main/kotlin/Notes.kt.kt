class Notes: Items<Note>() {
    override var itemsList: List<Note> = listOf()

    fun showNotes() {
        this.show()
        println("Notes shown")
    }
}