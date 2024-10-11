class MainMenu(private val archives: MutableList<Archive>, private val ioHandler: IOHandler) {

    fun show() {
        while (true) {
            val archiveNames = archives.map { it.name }

            ioHandler.showList(
                title = "Список архивов:",
                items = archiveNames,
                footer = "${archives.size + 1}. Выход",
                createOp = "0. Создать архив"
            )

            when (val choice = ioHandler.getUserChoice()){
                0 -> createArchive()
                in 1..archives.size -> ArchiveMenu(archives[choice!! - 1], ioHandler).show()
                archives.size + 1 -> {
                    ioHandler.showMessage("Выход из программы")
                    break
                }
                else -> ioHandler.showMessage("Неверный выбор, попробуйте снова.\n")
            }
        }
    }

    private fun createArchive() {
        ioHandler.showMessage("Введите имя архива:")
        val name = readlnOrNull().orEmpty()
        if(name.isNotEmpty()) {
            archives.add(Archive(name))
            ioHandler.showMessage("Архив '$name' создан.\n")
        }else{
            ioHandler.showMessage("Имя архива не может быть пустым.\n")
        }
    }
}