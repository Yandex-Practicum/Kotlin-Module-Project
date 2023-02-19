package com.example.practicumkotlin

import com.example.practicumkotlin.Menu.Companion.archive
import com.example.practicumkotlin.Menu.Companion.menuNote
import java.util.*
import kotlin.String

class Menu {
    companion object {
        val archive = ArchiveImpl()
        val menuNote = MenuNote()
    }
     fun menuStart() {

        println(
            "Для запуска приложения введите Start," +
                    " при вводе других слов, символов программа будет закрыта"
        )
        val sc = Scanner(System.`in`)
        val answer = sc.nextLine()

        while (isStartStop(answer)) {
            val sca = Scanner(System.`in`)
            printMenuArchive()
            val answer = sca.nextLine()
            val numberMenu = answer?.trim()?.toIntOrNull()
            while (isCheckEnter(numberMenu)) {
                println("Введите число")
                break
            }

            if (numberMenu != null) {
                when (numberMenu.toInt()) {

                    1 -> {
                        menuArchive()
                        createArchiveMenu(numberMenu)
                    }
                    0 -> {
                        println("Вы вышли")
                        break
                    }
                }
            }
        }
    }
}
 fun createArchiveMenu(number: Int) {
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
                    println("Создание архива")
                    println("Введите название архива")
                    archive.createArchive(scannerNote.nextLine())
                    println(archive.listArchive)
                    menuArchive()
                }

                2 -> {
                    println("Выбрать архив")
                    println(archive.listArchive)
                    menuNote.menuNote()
                    menuNote.createNoteMenu(numberNote)
                    menuArchive()
                }
                0 -> {
                    println("Вышли в предыдущее меню")
                    break
                }

            }
        }
    }
}


 fun menuArchive() {
    println(
        "1 - Создать архив\n" +
                "2 - Все архивы\n" +
                "0 - Вернуться в предыдущее меню"
    )
}

 fun isStartStop(str: String): Boolean {
    if (str == "Start") {
        return true
    }
    return false
}

 fun printMenuArchive() {
    println(
        "1 - Архивы\n" +
                "0 - Выход"
    )
}

 fun isCheckEnter(str: Int?): Boolean {
    if (str == null) {
        return true
    }
    return false
}
