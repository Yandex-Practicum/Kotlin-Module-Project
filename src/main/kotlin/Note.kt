class Note : Screen() {
//    override var menu: MutableList<String> = mutableListOf()
    private var listOfNotes = listOf<String>()
    override val theme = "заметок"
    override val title = "заметку"

    fun run(store: LinkedHashMap<String, MutableList<String>>, archStorageItem: String) {

        listOfNotes = store[archStorageItem]?.toList() ?: listOf()

        show(listOfNotes, theme, title)
        var inp = readln()

        while (!inputError(inp, listOfNotes.size + 1)) { //errors check
            show(listOfNotes, theme, title)
            inp = readln()
        }
        when (inp.toIntOrNull()) {
            0 -> {
                showCreate(title, store, archStorageItem); run(store, archStorageItem)
            }
            in 1 until listOfNotes.size + 1 -> showNote(archStorageItem, store, inp.toInt() - 1)
            listOfNotes.size + 1 -> Archive().run(store)
        }
    }
}