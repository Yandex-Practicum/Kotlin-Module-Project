import Data.Archieve
import Data.Note
import java.util.Scanner

val archievePage = ArchievePage()

fun main() {
    while (true){
        println("1.Выбрать архив\n2.Создать архив\n3.Выйти из программы")

        val scan = Scanner(System.`in`)
        val value = scan.nextLine()
        if(archievePage.isInputCorrect(value)){
            when(value.toInt()){
                1 -> selectArch()
                2 -> createArch()
                3 -> break
            }
        }
        else {
            println("Необходимо ввести число")
            continue
        }
    }
}

fun selectArch(){

    val scan = Scanner(System.`in`)

    println("Список архивов")
    if (archievePage.showAllArchieves() == null) {
        println("Список архивов пустой")
        main()
    }

    println(archievePage.showAllArchieves())
    val value = scan.nextLine().toInt()
    println(archievePage.chooseArchieve(value)?.name)

    while (true){
        println("1.Выбрать заметку\n2.Создать заметку\n3.Выйти в меню Архивов")
        when(scan.nextLine().toInt()){
            1 -> archievePage.chooseArchieve(value)?.let { selectNote(it) }
            2 -> archievePage.chooseArchieve(value)?.let { createNote(it) }
            3 -> break
        }
    }
}

fun createArch(){

    println("Создаем архив")

    val scan = Scanner(System.`in`)
    println("Введите имя архива:")
    val archName: String = scan.nextLine().toString()

    val archieve = Archieve(archName)

    archievePage.addArchieve(archieve)
}

fun selectNote(archieve: Archieve) {
    val scan = Scanner(System.`in`)
    println("Просматриваем содержимое архива")

    if (archieve.showAllNotes() == null) {
        println("Список заметок пустой")
        selectArch()
    }

    println(archieve.showAllNotes())
    while (true) {
        var noteID = scan.nextLine().toInt()
        when (noteID) {
            0 -> break
            else -> archieve.chooseNote(noteID)
        }
    }
}

fun createNote(archieve: Archieve){
    println("Создаем заметку")
    val scan = Scanner(System.`in`)

    println("Введите название заметки:")
    val noteName = scan.nextLine().toString()

    println("Введите описание заметки:")
    val noteDescription = scan.nextLine().toString()

    archieve.addNote(Note(noteName, noteDescription))
    println("Заметка добавлена")
}