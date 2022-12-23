class OpenArchiveScreen(private val noteList: MutableList<Note>, private val parent: ArchiveScreen) : Screen<Note>("заметку", noteList) {

    override fun back() {
        parent.show()
    }

    override fun add() {
        println("Вы собираетесь создать заметку.\nВведите имя или -1, чтобы отменить действие:")
        val name = readLine()!!
        if (name == "-1") {
            println("Действие отменено!")
            show()
            return
        }
        println("Введите текст заметки:")
        val content = readLine()!!
        noteList.add(Note(name, content))
        println("Заметка успешно создана!")
        show()
    }

    override fun select(id: Int) {
        println("Открываем заметку ${noteList[id - 1]}...")
        val note = OpenNoteScreen(noteList[id - 1], this)
        note.show()
    }
}