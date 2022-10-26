package view

import model.Archive
import presenter.Presenter
import java.lang.NumberFormatException
import java.util.*

class NoteListScreen(val archive: Archive, presenter: Presenter) :Screen(presenter) {
    val scanner = Scanner(System.`in`)
    override fun show() {
        println("_______NoteListScreen________")
        println("0 - НАЗАД")
        println("+ - добавить заметку")
        if (archive.notes.isEmpty()){
            println("пока ни одной заметки нет")

        }else {
            archive.notes.forEach {
                println(it.title)
            }
        }
        println("____________________________________")
        while (true){
            val command = scanner.nextLine()
            when(command){
                "0"->presenter.allArchivesScreen.show()
                "+"->println("NEXT SCREEN  ADD NOTE")
                else->{
                    try{
                        val note = archive.notes[command.toInt()-1]
                        println("SHOW NOTE SCREEN")
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