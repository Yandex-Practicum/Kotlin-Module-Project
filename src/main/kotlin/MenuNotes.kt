class MenuNotes(private val userNote: MutableList<UserNotes>, archName: String) :
    MenuCommon(TitleTypes.NOTES, archName) {
    override fun goPrevious() {
        //go back to WorkArchives
        println("Возврат в меню архивов")
    }

    override fun createElement() {
        //add new item to note
        NoteTools.printCreateNewNoteHead()

        print("Введите наименование заметки: ")
        val name = NoteTools.waitUserResponse(UserResponseType.TEXT, 0, 0)
        print("Введите текст заметки: ")
        val text = NoteTools.waitUserResponse(UserResponseType.TEXT, 0, 0)
        userNote.add(UserNotes(name, text))
        NoteTools.printNoteCreatedHead()
        println("Наименование: $name")
        println("Текст: $text")
        onCreate()
    }

    override fun selectElement() {
        println("Для открытия заметки выберите соответствующий пункт или 1.Выход")
        var userSelected = 0
        while (true) {
            userSelected = NoteTools.waitUserResponse(UserResponseType.SELECTED_MENU, 1, userNote.size + 1).toInt()
            if (userSelected > userNote.size + 1) println("Введено значение отсутствующей заметки")
            else break
        }
        if (userSelected > 1) {
            showSelectedNote(userNote[userSelected - 2])
            onCreate()
        }
    }

    override fun showAllElements() {
        NoteTools.printAllNotesHead()
        if (userNote.size > 0) {
            println("1. Выход")
            var cnt = 1
            for (i in userNote) {
                println("${++cnt}. Заметка: ${i.noteName}")
            }
            selectElement()
        } else {
            println("Список заметок пуст!!!")
            onCreate()
        }
    }

    private fun showSelectedNote(note: UserNotes?) {
        note?.let {
            NoteTools.printNoteHead()
            println("Наименование заметки: ${it.noteName}")
            println("Текст заметки: ${it.noteText}")
        }
    }

    override fun goNext() {}
}

