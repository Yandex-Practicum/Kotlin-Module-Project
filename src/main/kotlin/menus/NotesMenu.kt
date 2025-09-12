package menus

import models.Archive
import java.util.*

fun notesMenu(archive: Archive, scanner: Scanner) {
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
        println("\n--- Архив: ${archive.name.ifEmpty { "(без имени)" }} ---")
        println("0. Создать заметку")
        archive.notes.forEachIndexed { i, note ->
            println("${i + 1}. ${note.name.ifEmpty { "(без названия)" }}")
        }
        println("${archive.notes.size + 1}. Назад")

        when (val choice = inputNumber(archive.notes.size + 2)) {
            0 -> createNoteMenu(archive, scanner)
            in 1..archive.notes.size -> viewNoteMenu(archive.notes[choice - 1], scanner)
            archive.notes.size + 1 -> return
        }
    }
}
