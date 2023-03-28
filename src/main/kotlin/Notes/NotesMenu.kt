package Notes

import Archive.Archive
import Menu


import java.util.*

class NotesMenu(){
    val notesMenu: MutableList<Notes> = mutableListOf()
    fun add(notesMenu: MutableList<Notes>) {
        println("Введите название заметки")
        val noteName = Scanner(System.`in`).nextLine()
        println("Введите текст заметки")
        val noteText = Scanner(System.`in`).nextLine()
        notesMenu.add(notesMenu.size - 1, Notes (noteName, noteText))
        println("Заметка создана")
    }
    fun show(notesMenu: MutableList<Notes>){
        if (notesMenu.size == 0) {
            notesMenu.add(Notes("Создать заметку", ""))
            notesMenu.add(Notes("Выход", ""))
        }
        println("3AMETKИ")
        for (i in 0 until  notesMenu.size) {
            println("$i. ${notesMenu [i].name}")
    }
    }
    fun interact(notesMenu: MutableList<Notes>) {
        while (true) {
            try {
                show(notesMenu)
                val userInputMenuItem = Scanner(System.`in`).nextInt()
                if ((userInputMenuItem > notesMenu.size - 1) or (userInputMenuItem < 0)) {
                    println("Введите число в рамках предложенных вариантов")
                    continue
                }
                when (userInputMenuItem) {
                    0 -> add(notesMenu)
                    notesMenu.size - 1 -> return
                    else -> {
                        println("Текст заметки: ")
                        println(notesMenu.get(userInputMenuItem).textNote)
                    }
                }
            } catch (e: java.util.InputMismatchException) {
                println("Введите число в рамках предложенных вариантов")
            }
        }
    }
}