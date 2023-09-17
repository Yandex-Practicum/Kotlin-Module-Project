class NotesApp {


    fun start() {
        println("$SAY_HELLO\n$LINES_DIVIDER")
        ArchivesMenu().showMenu()
        println("${LINES_DIVIDER} ${SAY_GOODBYE}")
    }


    companion object {
        private const val SAY_HELLO = "\nПривет! Приложение 'Заметки' начинает работу"
        private const val SAY_GOODBYE = "\nРабота приложения 'Заметки' завершена. До свидания!"
        private const val LINES_DIVIDER = "----------------------------------------------------"

    }
}

