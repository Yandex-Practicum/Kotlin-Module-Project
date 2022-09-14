class ScreenArchive : Screen (ScreenType.ARCHIVE) {
    private var activeArc: Archive? = null
    fun start(activeArchive: Archive) {
        activeArc = activeArchive
        while (true) {
            renderMenu(activeArchive.notes)
            when (val selectedMenuItem = selectMenuItem(activeArchive.notes.size)) {
                -2 -> {
                    println("\t...возвращаемся назад на главный экран к списку архивов")
                    break
                } // exit menu
                -1 -> addNewNote(activeArchive)
                0 -> showErrorMessage(activeArchive.notes.isEmpty())
                else -> {
                    val note = activeArchive.notes[selectedMenuItem - 1]
                    println("\t...выбрана заметка '$note'")
                    showNote(note)
                }
            } //> when
        } //> while
    } //> start()

    private fun addNewNote(arc: Archive) {
        // enter note name
        var noteName: String
        while (true) {
            print("Введите название новой заметки: ")
            noteName = scanner.nextLine()
            if (!checkUniqueNoteName(arc, noteName)) {
                println("\t...такое имя заметки уже существует, надо ввести уникальное имя")
                continue
            }
            if (noteName.isEmpty()) {
                println("\t...необходимо ввести не пустое имя")
                continue
            }
            break
        }

        // enter note text
        print("Введите текст заметки: ")
        val noteText = scanner.nextLine()
        arc.notes.add(Note(noteName, noteText))
        println("\t...в архив '${arc.name}' добавлена новая заметка '$noteName'")
    }

    private fun showNote(note: Note) {
        println("\nНазвание заметки: ${note.name}")
        println("Текст заметки: ${note.text}")
    }

    override fun getScreenSpecificName(): String {
//        return if (activeArc != null)
//            activeArc!!.name
//        else
//            ""
        return activeArc?.name.orEmpty()
    }

    private fun checkUniqueNoteName(arc: Archive, name: String): Boolean {
        for (note in arc.notes)
            if (note.name == name)
                return false
        return true
    }
} //> class

