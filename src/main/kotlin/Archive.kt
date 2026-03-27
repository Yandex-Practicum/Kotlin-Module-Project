import java.util.Scanner

data class Archive(
    val name: String,
    val notes: MutableList<Note> = mutableListOf()
    ) {
    fun archiveMenu(){
        println("Выбран архив $name")

        while (true){
            if (notes.isEmpty()){
                println("Заметок пока нет")
            }

            println("Введите команду: \n 0. Выход \n 1. Создать заметку ")
            notes.forEachIndexed { index, note ->
                println(" ${index + 2}. ${note.name}") }

            val command = Utils.commandChecker() ?: continue
            when {
                command == 0 -> {
                    println("Выход")
                    return
                }

                command == 1 -> {
                    println("Создание заметки")

                    println("Введите название заметки")
                    val noteName = Scanner(System.`in`).nextLine()

                    println("Введите содержимое заметки $noteName")
                    val noteBody = Scanner(System.`in`).nextLine()
                    addNote(Note(noteName, noteBody))
                }
                command in 2 .. notes.size + 1 -> {
                    val selectedNote = notes[command - 2]
                    selectedNote.openNote()
                }
                else -> println("Ошибка: выберите команду из списка")
            }
        }
    }
    fun addNote(note: Note) {
        notes.add(note)
    }
}