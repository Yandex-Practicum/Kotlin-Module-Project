import dataClass.Archive
import dataClass.Note
import java.util.Scanner

class ScreenSelectionArchive() {

    val listArchive = mutableListOf<Any>("0. Создать архив", "1. Выход")
    var executeCode = true
    var choiseNote = true
    var counter = 0
    fun start(){

        while(executeCode) {
            println("Меню Архивы")
            listArchive.forEachIndexed{ index, archive ->
                if (archive is Archive) println("$index. ${archive.name}")
                else println(archive)
            }
            println("Введите цифру для выбора действия из меню или просмотра содержимого архива")
            val enterString  = Scanner(System.`in`).nextLine()
            try {
                val enterInt = enterString.toInt()
                if (listArchive.size > enterInt) {
                    when(enterInt){
                        1 -> {
                            listArchive.clear()
                            return
                        }
                        0 -> {val archive = ScreenCreateArchive().create(listArchive)
                            listArchive.add(archive)}
                        else -> {
                            val arc: Any = listArchive[enterInt]
                            choiseNote = true
                            if(arc is Archive){
                                while (choiseNote){
                                    println(arc.name)
                                    arc.notes.forEachIndexed{ index, note ->
                                        if (note is Note) println("$index. ${note.title}")
                                        else println(note)
                                    }
                                    println("Введите цифру для выбора действия из меню или просмотра содержимого записки")
                                    val enterStringNote  = Scanner(System.`in`).nextLine()
                                    try {
                                        val enterIntNote = enterStringNote.toInt()
                                        if(arc.notes.size > enterIntNote){
                                        when (enterIntNote){
                                            1 -> choiseNote = false
                                            0 -> {val note = ScreenCreateNote().create(arc.notes)
                                               arc.notes.add(note)}//
                                            else -> {
                                                val bodyNote = arc.notes[enterIntNote]
                                                if(bodyNote is Note){
                                                    println(bodyNote.body)
                                                    println("")
                                                }
                                            }
                                        }}
                                        else{
                                            println("$enterIntNote нет в списке меню.")
                                        }
                                    }
                                    catch (nfe: NumberFormatException) {
                                        println("Ввели что то другое")
                                    }
                                }
                            }
                        }
                    }
                }
                else{
                    println("$enterInt нет в списке меню.")
                }
            }
            catch (nfe: NumberFormatException){
                println("Ввели что то другое")
            }
            println("")
        }
    }
}


