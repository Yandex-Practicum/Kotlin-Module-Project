object App {

    var currentArchive: Archive? = null
    var currentNote: Note? = null

    fun start() {
        println("Добро пожаловать в приложение 'Заметки'!")
        ListOfArchivesMenu.execute()
    }
}