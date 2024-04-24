class NoteListScreen(private var archive: Archive): Screen()
{
    override fun goToNextScreen(i: Int) {
        noteScreen(i)
    }
    private fun noteScreen(noteNumber: Int) {
        println(archive.noteList[noteNumber].toString())
        while (true) {
            println("0. Посмотреть текст заметки\nЛюбой другой ввод. Вернуться к списку заметок")
            when (readln()) {
                "0" -> println(archive.noteList[noteNumber].takeText())
                else -> break
            }
        }
    }
}