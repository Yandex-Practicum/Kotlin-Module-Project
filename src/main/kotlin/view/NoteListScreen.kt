package view

import model.Archive
import presenter.Presenter
import java.lang.NumberFormatException
import java.util.*

class NoteListScreen(private val archive: Archive, presenter: Presenter, val function: () -> (Unit)) :Screen(presenter) {
    private val scanner = Scanner(System.`in`)
    override fun show() {
        println("3______${archive.name}_______3")
        println("0 - НАЗАД")
        println("+ - добавить заметку")
        if (archive.notes.isEmpty()){
            println("пока ни одной заметки нет")
        }else {
            archive.notes.forEachIndexed { index, note ->
                println("${index+1} - ${note.title}")
            }
        }
        println("____________________________________")
        while (true){
            val command = scanner.nextLine()
            when(command){
                "0"->function.invoke()
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