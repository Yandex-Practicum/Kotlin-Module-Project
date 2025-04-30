import java.util.Scanner

class CreateNoteScreen(val notesScreen: NotesScreen): ScreenPrototype(){
    var notes: MutableList<Note>? = null
        set(value){
            field = value
        }
    override fun display() {
        println("\nВведите имя заметки")
        putExit()
        var title = getText()
        when(title.toIntOrNull()){
            1->notesScreen.display()
            else -> {
                println("Введите текст для заметки")
                var text = getText()
                if(notes!!.add(Note(title,text))) println("Заметка $title успешно добавлен")
                else println("Что то пошло не так")
                notesScreen.display()
            }
        }
    }
}
