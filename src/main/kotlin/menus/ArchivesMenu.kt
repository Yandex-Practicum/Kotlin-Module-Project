package menus

import models.Archive
import java.util.*

fun archivesMenu(scanner: Scanner) {
    val archives = mutableListOf<Archive>()

    fun inputNumber(limit: Int): Int {
        while (true) {
            val input = scanner.nextLine()
            val num = input.toIntOrNull()
            if (num == null || num !in 0 until limit) {
                print("Ошибка: повторите ввод: ")
            } else return num
        }
    }

    while (true) {
        println("\n--- Список архивов ---")
        println("0. Создать архив")
        archives.forEachIndexed { i, archive ->
            println("${i + 1}. ${archive.name.ifEmpty { "(без имени)" }}")
        }
        println("${archives.size + 1}. Выход из программы")

        when (val choice = inputNumber(archives.size + 2)) {
            0 -> createArchiveMenu(archives, scanner)
            in 1..archives.size -> notesMenu(archives[choice - 1], scanner)
            archives.size + 1 -> {
                println("Выход из программы...")
                return
            }
        }
    }
}
