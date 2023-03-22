class NoteList : Commander() {

    private fun addNote() {
        println("Введите имя новой заметки:")
        val n = readLine()!!
        println("Введите текст заметки")
        val text = readLine()!!
        println("Заметка сохранена")
        val newNote = Note(n, text)
        noteText[(noteText.size + 1)] = newNote
    }

    override fun command() {
        for (j in 1..noteText.size) {
            val str = noteText[j]?.name
            println("$j. $str")
        }
    }

    override fun printing() {
        while (true) {
            println("Список заметок")
            println("0. Создать заметку")
            menuNumb = noteText.size + 1
            if (noteText.isNotEmpty()) command()
            println("${menuNumb}. Выход в меню архивов.")
            choice = commandReader()
            when (choice) {
                0 -> addNote()
                menuNumb -> return
                else -> if (noteText.contains(choice)) {
                    println("Текст заметки:")
                    println(noteText[choice]?.noteText)
                } else println("Заметки с выбранным номером не существует")
            }
        }
    }
}