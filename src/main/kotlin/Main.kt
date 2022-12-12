
import java.lang.IndexOutOfBoundsException
import kotlin.system.exitProcess

fun notesListScreen(archive: Archive) {
    println("Выберите заметку или введите 'архив' чтобы вернуться к архиву")
    val notes: MutableList<Note> = archive.getAllNotes()
    notes.forEachIndexed { index, note ->
        println("$index. ${note.name}")
    }
    try {
        val userChoice: String = readln()
        when (userChoice) {
            "архивы" -> singleArchiveScreen(archive)
            else -> {
                val userSelectedNote = notes[userChoice.toInt()]
                println("${userSelectedNote.content}")
                println("Нажмите на любую клавишу, чтобы вернуться")
                singleArchiveScreen(archive)
            }
        }
    }
    catch (e:NumberFormatException){
        println("Неверный ввод")
        notesListScreen(archive)
    }
    catch (e:IndexOutOfBoundsException){
        println("Неверный ввод")
        notesListScreen(archive)
    }

}

fun createNote() :Note {
    println("Введите название заметки")
    val noteName = readln()
    println("Введите содержимое заметки заметки")
    val noteContent = readln()
    val newNote = Note(noteName, noteContent)
    println("Заметка успешно создана")
    return newNote

}

fun singleArchiveScreen (userSelectedArchive: Archive) {
    println("1. Создать заметку")
    println("2. Показать все заметки")
    println("3. Вернуться в список архивов")
    val userChoice = readln()
    when (userChoice) {
        "1" -> {
            userSelectedArchive.addNote(createNote())
            singleArchiveScreen(userSelectedArchive)
        }
        "2" -> notesListScreen(userSelectedArchive)
        "3" -> archiveScreen()
        else -> {
            println("Неверный ввод")
            singleArchiveScreen(userSelectedArchive)
        }
    }

}

fun archiveScreen() {
    println("Выберите архив или введите 'меню' чтобы вернуться в начальное меню")
    archievs.forEachIndexed { index, archive ->
        println("$index. ${archive.name}")
    }
    try {
        val userChoice = readln()
        when (userChoice) {
            "меню" -> menu()
            else -> {
                val userSelectedArchive = archievs[userChoice.toInt()]
                singleArchiveScreen(userSelectedArchive)

            }
        }
    }
    catch (e:NumberFormatException){
        println("Неверный ввод")
        archiveScreen()
    }
    catch (e:IndexOutOfBoundsException){
        println("Неверный ввод")
        archiveScreen()
    }




}

fun createArchive() : Archive{
    println("Введите название архива")
    val archiveName = readln()
    val newArchive = Archive(archiveName)
    println("Архив успешно создан")
    return newArchive

}


var archievs: MutableList<Archive> = mutableListOf()



fun menu(){
    println("Меню")
    println("1. Создать архив")
    println("2. Список архивов")
    println("3. Выход")
    val userInput = readln()
    when (userInput) {
        "1" -> {
            archievs.add(createArchive())
            menu()
        }
        "2" -> archiveScreen()
        "3" -> exitProcess(1)
        else -> {
            println("Неверный ввод")
            menu()
        }


    }
}

fun main() {
    menu()


}

