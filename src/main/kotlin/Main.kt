import kotlin.random.Random
import kotlin.collections.ArrayList


class Note (var title : String, val textItself: MutableList<String>)

fun main(args: Array<String>) {
    val noteList: MutableList<Note> = ArrayList()
    var line: String
    var check: Boolean

    println("Пожалуйста, выберите опцию из предоставленных ниже")
    println("1. Выбрать заметку")
    println("2. Создать заметку")
    println("(Для выбора опции введите номер)")

    line = readln()!!
    while(line != "1" && line != "2") {
        println("Пожалуйста, выберите одну из предоставленных опций. Введите только цифру опции без других символов")
        line = readln()!!
    }

    if (line == "2"){
        println("Введите название заметки")
        val title = readln()!!
        val mutableList: MutableList<String> = ArrayList()
        var textt: String

        println("Введите текст заметки")
        textt = readln()!!
        mutableList.add(textt)

        while (true) {
            println("Пожалуйста, выберите опцию из предоставленных ниже")
            println("1. Завершить создание заметки")
            println("2. Продолжить текст с нового абзаца")

            line = readln()!!
            while(line != "1" && line != "2") {
                println("Пожалуйста, выберите одну из предоставленных опций. Введите только цифру опции без других символов")
                line = readln()!!
            }

            if (line == "1") {
                break
            } else {
                println("Введите текст заметки")
                textt = readln()!!
                mutableList.add(textt)
            }
        }

        noteList.add(createNote(title, mutableList))
    } else if (line == "1") {
        if (noteList.isNotEmpty()) {
            for (note : Note in noteList){
                println(note.title)
            }

            println("Пожалуйста, выберите одну из предоставленных опций. Впишите название заметки")
            var noteTitle = readln()!!

            while(true) {
                check = false
                for (note: Note in noteList) {
                    if (noteTitle == note.title) {
                        showNote(note)
                        check = true
                    }
                }

                if(!check) {
                    println("Вы не ввели существующее название, попробуйте снова.")
                    noteTitle = readln()!!
                } else {
                    break
                }
            }
        } else {
            println("Заметок пока нет.")
        }
    }
}

fun createNote (title: String, textItself: MutableList<String>) : Note {
    return Note(title, textItself)
}

fun showNote (note: Note) {
    println("Заметка: ${note.title}")
    for((index, paragraph) in note.textItself.withIndex()) {
        println("$paragraph")
    }
}