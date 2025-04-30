class ScreenOfNote(private val notesScreen: NotesScreen) : ScreenPrototype(){
     fun display(note: Note) {
         println("\n${note.title}\n${note.text}")
         println("\n1. Выход")
        when(readLine()?.toIntOrNull()){
            1->notesScreen.display()
            else -> println("Некорректный ввод")
        }
    }

}
