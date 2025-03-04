class ArchiveMenu(private val archives: MutableList<Archive>, private val navigator: MenuNavigator) {
    fun show() {
        while (true) {
            val options = listOf( Pair("Создать архив", { createArchive() }), Pair("Выход", { null })) + archives.map { Pair(it.name, { showNotes(it) })
            }

            val choice = navigator.showMenu(options)
            if (choice == null) {
                println("Программа завершена")
                break
            }
        }
    }


    private fun createArchive(): Archive {
        println("Введите название архива:")
        val name = readLine() ?: ""
        if (name.isEmpty()) {
            println("Архив не может быть без имени.")
            return createArchive()
        }

        val archive = Archive(name)
        archives.add(archive)
        println("Архив создан. Возвращаемся к меню.")
        return archive
    }

    private fun showNotes(archive: Archive) {
        NoteMenu(archive, navigator).show()
        println("Возвращаемся к архивам.")
    }
}