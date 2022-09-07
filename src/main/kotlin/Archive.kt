class Archive(private val nameArh: String, private val content: ArrayList<Note>) :
    Common(name = nameArh), ActWhile {

    fun showNotesList() {
        val menu = Menu("Список заметок архива: '$nameArh'", "заметку", content) //0. Создать
        menu.showMenu()
    }

    fun waitingAction() {
        userResultAction(content)
    }

    //region override fun
    override fun createAction() {
        if (createNote())
            printHeader("Новая заметка создана.", false)
        showNotesList()
    }

    override fun showAction(num: Int) {
        printHeader("Просмотр содержимого заметки.", true)
        content[num - 1].showData()
        showNotesList()
    }

    override fun wrongNumberAction(number: String) {
        //printHeader("Введено некорретное число: $number", false)
        printError(number)
        showNotesList()
    }
    //endregion

    private fun createNote(): Boolean {
        printHeader("Создание новой заметки.", true)
        val nameNote = askActionWithExit("Введите наименование заметки")
        if (nameNote != "q") { //!nameNote.equals("q")
            val contentNote = askActionWithExit("Введите текст заметки")
            if (contentNote != "q")
                return content.add(Note(nameNote, contentNote, this))
            else
                cancelCreateNote()
        } else {
            cancelCreateNote()
        }
        return false
    }

    private fun cancelCreateNote() {
        printHeader("Создание заметки отменено.", false)
    }
}