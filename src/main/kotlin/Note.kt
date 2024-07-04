data class Note (
    val noteName : String,
    val noteText: String
) {
    constructor() : this("","")

    fun createNote (archive: Archive) {
        println("Введите название, а затем текст заметки :")
        val newNote = Note(UserInput().textInput(),UserInput().textInput())
        archive.archiveList.add(newNote)
        println("Заметка под именем \"${newNote.noteName}\" успешно добавлена!")
    }

    fun allNotes(archive: Archive) {
        if (archive.archiveList.isEmpty()) {
            println("Архив заметок пуст!")
        } else {
            for (i in archive.archiveList.indices) {
                println("Заметка номер : ${i + 1} \nНазвание : ${archive.archiveList[i].noteName} \nТекст заметки : ${archive.archiveList[i].noteText} \n-----------------------")
            }
        }
    }
}
