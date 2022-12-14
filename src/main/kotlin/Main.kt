
import java.lang.IndexOutOfBoundsException
import kotlin.system.exitProcess

fun notesListScreen(archive: Archive) {
    val notes: MutableList<Note> = archive.getAllNotes()
    try {
        var userChoice = selectScreen(notes)
        when (userChoice) {
            "назад" -> singleArchiveScreen(archive)
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
    val userChoice = defaultInputScreen("Архивы \n" +
            "1. Создать заметку \n2. Список заметок \n3. Вернуться в список архивов")
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


fun <T: Title> selectScreen(mutableList: MutableList<T>) : String  {
    println("Введите нужную вам цифру или введите 'назад' чтобы вернуться назад")
    mutableList.forEachIndexed { index, t ->
        println("$index. ${t.name}")
    }
    var userChoice = readln()
    return userChoice

}


fun archiveScreen() {
    try {
        var userChoice = selectScreen(archievs)
        when (userChoice) {
            "назад" -> menu()
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



fun defaultInputScreen(string: String) : String {
    println(string)
    val userInput = readln()
    return userInput
}


var archievs: MutableList<Archive> = mutableListOf()



fun menu(){
    val userInput = defaultInputScreen("Меню \n" +
            "1. Создать архив \n2. Список архивов \n3. Выход")
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

