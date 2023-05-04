class ArchiveMenu : Menu() {
    val archives = mutableListOf<Archive>()
    override var commands = mutableListOf<Command>()
    val openingArchive: (Int) -> Unit = { index ->
        val archive = archives[index - 1]
        println("Вы находитесть в архиве ${archive.nameArchive}")
        val notesMenu = NotesMenu(archive)
            notesMenu.createListCommandAndView()
    }

    override fun createListCommandAndView() {
        commands = mutableListOf<Command>().apply {
            add(Command("Создать архив") { createArchive() })
            archives.forEach {
                add(Command(it.nameArchive, openingArchive))
            }
            add(Command("Выйти") { exit() })
        }
        view(commands)
    }

    private fun createArchive() {
        val archive = Archive.create()
        archives.add(archive)
        commands.add(commands.size - 1, Command(archive.nameArchive, openingArchive))
    }
}

