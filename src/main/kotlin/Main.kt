import java.util.Scanner

fun main(args: Array<String>) {
    startMenu()
}

data class Note(val name : String, val text : String)

data class Archive(val name : String,val notes : MutableList<Note> = mutableListOf())

val scanner = Scanner(System. `in`)

val archives = mutableListOf<Archive>()

fun startMenu() {
    var running = true
    while (running) {
        val options : List<String> = listOf("Создать архив") + archives.map {it.name} + "Выход"
        Menu ("\nСписок архивов:", options) { number ->
            when(number) {
                0 -> createArchive()
                in 1..archives.size -> openArchive(archives[number - 1])
                archives.size + 1 -> running = false
            }
        }.open()
    }
}

fun createArchive() {
    while(true) {
        println("\nВведите название архива:")
        val name = scanner.nextLine().trim()
        if (name.isEmpty()) {
            println("Название архива не может быть пустым")
            continue
        }
        archives.add(Archive(name))
        println("Архива с именем $name создан")
        return
    }
}

fun openArchive(archive : Archive) {
    var running = true
    while (running) {
        val options : List<String> = listOf("Создать заметку") + archive.notes.map {it.name} + "Выход"
        Menu ("\nСписок заметок:", options) { number ->
            when(number) {
            0 -> createNote(archive)
            in 1..archive.notes.size -> openNote(archive.notes[number - 1])
            archive.notes.size + 1 -> running = false
            }
        }.open()
    }
}

fun createNote(archive : Archive) {
    while(true) {
        println("\nВведите название заметки:")
        val name = scanner.nextLine().trim()
        if (name.isEmpty()) {
            println("Название заметки не может быть пустым")
            continue
        }
        while(true) {
            println("Введите содержание заметки:")
            val text = scanner.nextLine().trim()
            if (text.isEmpty()) {
                println("\nСодержание заметки не может быть пустым")
                continue
            }
            archive.notes.add(Note(name, text))
            println("Заметка с именем $name и содержанием '$text' создана")
            break
        }
        break
    }
}

fun openNote(note : Note) {
    println("\n Заметка: ${note.name}\n")
    println(note.text)
    val options : List<String> = listOf("Выход")
    var running = true
    while (running) {
        Menu("", options) { number ->
            when (number) {
                0 -> running = false
            }
        }.open()
    }
}
