import java.util.Scanner

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val archives = mutableListOf<Archive>()
    println("Привет! Это приложение заметки, она умеет хранить архив заметок.")
    println("Для выбора действия введи номер.")
    while (startProgram(scanner, archives)) {}
    scanner.close()
}

fun startProgram(scanner: Scanner, archives: MutableList<Archive>): Boolean{
    while (true) {
        println("Вы в главном меню. Выберите действие:")
        println("1. Создание и просмотр архива")
        println("0. Завершить работу")
        val number = tryCatch(scanner)
        when (number) {
            1 -> workingWithArchives(scanner, archives)
            0 -> return exitTheProgram()
            else -> println("Неверный ввод, попробуйте снова.")
        }
    }
}

fun workingWithArchives(scanner: Scanner, archives: MutableList<Archive>) {
    while (true) {
        println("Меню архивов.")
        if (archives.isEmpty()) {
            println("Нет доступных архивов. Создайте архив.")
        } else {
            println("Список архивов:")
            for (index in archives.indices) {
                val archive = archives[index]
                println("${index + 1}. ${archive.nameArchive}")
            }
        }
        println("${archives.size + 1}. Создать архив")
        println("0. Вернуться в главное меню.")

        val number1 = tryCatch(scanner)

        when (number1) {
            archives.size + 1 -> createArchive(scanner, archives)
            in 1..archives.size -> workingWithNotes(scanner, archives[number1 - 1])
            0 -> return
            else -> println("Неверный ввод, попробуйте снова.")
        }
    }
}

fun workingWithNotes(scanner: Scanner, archive: Archive) {
    while (true){
    println("Меню заметок для архива: ${archive.nameArchive}.")
    if (archive.notes.isEmpty()) {
        println("Нет доступных заметок. Создайте заметку.")
    } else {
        println("Список заметок:")
        for (index in archive.notes.indices) {
            val note = archive.notes[index]
            println("${index + 1}. ${note.nameNote}")
        }
    }
    println("${archive.notes.size + 1}. Создать заметку")
    println("0. Вернуться в меню архивов.")
    val number2 = tryCatch(scanner)
    when (number2) {
        in 1..archive.notes.size -> {
            contentOfTheNote(archive.notes[number2 - 1])
        }
        archive.notes.size + 1 -> createNote(scanner, archive)
        0 -> return
        else -> println("Неверный ввод, попробуйте снова.")
    }
        }
}

fun contentOfTheNote (note: Note){
    println("Название заметки: \"${note.nameNote}\"")
    println("Содержание: ${note.content}")
}

fun exitTheProgram(): Boolean {
    println("Вы завершили приложение. Ждем вас еще раз, были очень рады!")
    return  false
}

fun createArchive(scanner: Scanner, archives: MutableList<Archive>) {
    while (true) {
        scanner.nextLine()
        println("Введите название архива, который желаете создать:")
        val archiveName = scanner.nextLine()
        if (archiveName.isNotEmpty()) {
            archives.add(Archive(archiveName))
            println("Архив \"$archiveName\" создан.")
            break
        } else {
            println("Ошибка!!!")
            println("Название заметки не может быть пустым.")
            println("Попробуйте снова.")
        }
    }
}

fun createNote(scanner: Scanner, archive: Archive) {
    while (true) {
        scanner.nextLine()
        println("Введите название заметки:")
        val noteName = scanner.nextLine()
        if (noteName.isNotEmpty()) {
            println("Введите содержание заметки:")
            val noteContent = scanner.nextLine()
            if (noteContent.isNotEmpty()) {
                archive.notes.add(Note(noteName, noteContent))
                println("Заметка \"$noteName\" создана в архиве \"${archive.nameArchive}\".")
                break
            } else {
                println("Ошибка!!!")
                println("Название заметки не может быть пустым.")
                println("Попробуйте снова.")
            }
        } else {
            println("Ошибка!!!")
            println("Название заметки не может быть пустым.")
            println("Попробуйте снова.")
        }
    }
}

fun tryCatch(scanner: Scanner): Int {
    while (true) {
        try {
            return scanner.nextInt()
        } catch (e: Exception) {
            println("Неверный ввод, попробуйте снова.")
            scanner.nextLine()
        }
    }
}