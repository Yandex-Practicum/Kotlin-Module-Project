package view

import model.Archive
import presenter.Presenter
import java.lang.NumberFormatException
import java.util.*

class NoteListScreen(private val archive: Archive, presenter: Presenter,  function: () -> (Unit)) :Screen(presenter,function) {
    override fun show() {
        println("Screen #3______архив: ${archive.name}_______")
        println("0 - НАЗАД")
        println("+ - добавить заметку")
        println()
        if (archive.notes.isEmpty()){
            println("пока ни одной заметки нет")
        }else {
            archive.notes.forEachIndexed { index, note ->
                println("${index+1} - ${note.title}")
            }
        }
        println("____________________________________")
        while (true){
            when(val command = scanner.nextLine()){
                "0"->   onBackPressed.invoke()
                "+"-> {
                    NoteCreationScreen(archive, presenter,::show).show()
                }
                else->{
                    try{
                        val note = archive.notes[command.toInt()-1]
                        NoteScreen(note, presenter,::show).show()
                    }catch (e: NumberFormatException){
                        println("некорректное значение")
                    }
                    catch (e :IndexOutOfBoundsException){
                        println("нет такого значения")
                    }
                }
            }
        }
    }
}