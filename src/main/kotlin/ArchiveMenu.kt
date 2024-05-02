open class ArchiveMenu(private val archives: MutableList<Archive>) : Menu() {
    private var currentArchive: Archive? = null
    init {
        archives.add(Archive("Создать архив"))
    }
    override fun show() {
        println("Список архивов:")
        for (i in archives.indices) {
            println("$i. ${archives[i].name}")
        }
        println("${archives.size}. Выход")
    }

    override fun handleInput(input: String) {
        when (input) {
            "0" -> createArchive()
            in archives.indices.map { it.toString() } -> viewArchive(archives[input.toInt()])
            archives.size.toString() -> exit()
            else -> invalidInput()
        }
    }

    private fun createArchive() {
        println("Введите имя архива:")
        val name = readLine()!!
        if (name.isEmpty() || name.isBlank()) {
            println("Имя архива не может быть пустым")
            createArchive()
        } else {
            archives.add(Archive(name))
            println("Архив создан")
        }
    }
    private fun exit() {
        println("Выход из программы")
        System.exit(0)
    }
    override fun viewArchive(archive: Archive) {
        currentArchive = archive
        println("Выберите заметку:")
        val notes = archive.notes
        println("0. Создать заметку")
        for (i in notes.indices) {
            println("${i + 1}. ${notes[i].text}")
        }
        println("${notes.size+1}. Выход")
        val input = readLine()!!
        when (input) {
            "0" -> createNote(archive)
            in "1"..notes.size.toString() -> {
                viewNote(notes[input.toInt()-1])
            }
            (notes.size+1).toString() -> return
            else -> {
                invalidInput()
                viewArchive(archive)
            }
        }
    }

    private fun createNote(archive: Archive) {
        println("Введите текст заметки:")
        val text = readLine()!!
        if (text.isEmpty() || text.isBlank()) {
            println("Текст заметки не может быть пустым")
            createNote(archive)
        } else {
            archive.notes.add(Note(text))
            println("Заметка создана")
            viewArchive(currentArchive!!)
        }
    }
    override fun viewNote(note: Note) {
        println("Текст заметки: ${note.text}")
        println("0. Выход")
        val input = readLine()!!
        when (input) {
            "0" -> viewArchive(currentArchive!!)
            else -> {
                invalidInput()
                viewNote(note)
            }
        }
    }
}
