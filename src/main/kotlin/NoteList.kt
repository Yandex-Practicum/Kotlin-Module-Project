class NoteList() { // Проверка корректности ввода в классе Input
    private val noteList: MutableSet<Note> = mutableSetOf() // noteList хранит список Заметок
    var activeNote: Note = Note(" ") // В activeNote хранится номер выбранной Заметки

    // Визуальный вывод Экран 2 Список заметок со списком команд
    val menuNoteList: () -> Unit = {
        var index = 0;
        println("-------Список ЗАМЕТОК-------")
        var menu = "$index. - Создать заметку \n"
        if (noteList.isEmpty()) menu += "Список заметок пуст \n"

        noteList.forEach { note ->
            index++
            menu += "${index}. - ${note.name} \n"
        }
        menu += "${noteList.size + 1}. - Вернуться к списку Архивов"
        println(menu)
    }

    // Экран 2 Список заметок выбираем пункт
    val choose: (n: Int) -> Unit = {  // Проверка корректности ввода в классе Input
            n ->
        when (n) {
            0 -> MENU.nav = MENU.NOTE_CREATE
            in 1..noteList.size -> {
                this.activeNote = setActive(n);
                println("Выбрана заметка N$n - ${activeNote.name}")
                MENU.nav = MENU.NOTE_SHOW
            }

            noteList.size + 1 -> MENU.nav = MENU.ARCHIVE_LIST
            else -> println("Команды или заметки с №$n нет в списке")
        }
    }

    // Создание новой заметки
    val createSome: (name: String) -> Unit = { name ->
        this.noteList.add(Note(name))
        MENU.nav = MENU.NOTE_LIST
    }

    // Выбор активной заметки
    private fun setActive(number: Int): Note {
        var iterator = 0
        for (note in noteList) {
            iterator++
            if (iterator == number) return note
        }
        return this.activeNote
    }

    override fun toString(): String {
        var str = ""
        if (noteList.isEmpty()) return "Пусто" // если нет заметок в списке
        noteList.forEachIndexed { index, s -> str += "$index) ${s.name} \n" } // список заметок
        return str
    }
}