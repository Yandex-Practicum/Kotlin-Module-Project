class Archive(archiveName: String): Renderable {
    var archiveName: String = ""
    var noteList = mutableListOf<Note>()




    fun showNotes(){
        if(noteList.isNotEmpty())
        for(note in noteList) {
            println(note.noteName)
        } else {
            println("Заметок нет. Создайте заметку")
        }
    }

    fun addNote(){
        println("Введите название заметки")
        val noteName = getTextInput()
        println("Введите содержание заметки")
        val noteContent = getTextInput()
        val note = Note(noteName, noteContent)
        noteList.add(note)
    }


    fun getName(): String {
        return archiveName
    }



    override var listOfOptions: MutableList<String?> = mutableListOf("Создать заметку", "Показать заметки", "Назад")

}