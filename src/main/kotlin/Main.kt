fun main() {
    //структура хранения архивов типа List
    val userArchive = mutableListOf<UserArchives>()

    //заголовок
    NoteTools.printContext(TitleTypes.HEAD)
    //переход в меню "Архивы" и переходим по: Архивы <-> Заметки
    while (true) {
        MenuArchives(userArchive).onCreate()
    }
}

//структура хранения архивов: list(archiveName, list(noteName, noteText))
data class UserArchives(val archiveName: String, val notesList: MutableList<UserNotes>)

//структура хранения заметок: list(noteName, noteText)
data class UserNotes(val noteName: String, val noteText: String)


