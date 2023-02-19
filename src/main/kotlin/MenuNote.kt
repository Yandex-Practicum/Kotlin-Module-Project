package com.example.practicumkotlin

import java.util.*

class MenuNote {
    fun createNoteMenu(number: Int) {
        while (number != 0) {
            val scannerNote = Scanner(System.`in`)
            val answer = scannerNote.nextLine()
            val numberNote = answer?.trim()?.toIntOrNull()
            while (isCheckEnter(numberNote)) {
                println("Введите число")
                break
            }
            if (numberNote != null) {
                when (numberNote.toInt()) {
                    1 -> {
                        println("Введите название архива")
                        val scArch = Scanner(System.`in`).nextLine()
                        println("Введите заметку")
                        val scNote = Scanner(System.`in`).nextLine()
                        Menu.archive.addNoteToTheArchive(scArch,scNote)
                        println(Menu.archive.listArchive)
                        menuNote()
                    }

                    2 -> {
                        println("Просмотр заметок\n" +
                                "Введите название архива")
                        println(Menu.archive.listArchive)
                        Menu.archive.printNote(scannerNote.nextLine())
                        menuNote()

                    }
                    0 -> {
                        break
                    }

                }
            }
        }
    }

    fun menuNote() {
        println(
            "1 - Создать заметку\n" +
                    "2 - Посмотреть заметку\n" +
                    "0 - Вернуться в предыдущее меню"
        )
    }
}