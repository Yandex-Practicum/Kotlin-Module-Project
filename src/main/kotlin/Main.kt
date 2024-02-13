import Data.Archieve
import Data.Note
import java.util.Scanner

val archievePage = PaigeLogic()

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
                else -> println("Выберите элемент меню")
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
    var archieveID = scan.nextLine().toInt()
    println(archievePage.chooseArchieve(archieveID)?.name)

    while (true){
        println("1.Выбрать заметку\n2.Создать заметку\n3.Выйти в меню Архивов")
        var noteID = scan.nextLine()
        if (archievePage.isInputCorrect(noteID)){
            when(noteID.toInt()){
                1 -> archievePage.chooseArchieve(archieveID)?.let { selectNote(it) }
                2 -> archievePage.chooseArchieve(archieveID)?.let { createNote(it) }
                3 -> break
                else -> println("Выберите элемент меню")
            }
        }
        else {
            println("Необходимо ввести число")
            continue
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
    if (archieve.showAllNotes() == null) {
        println("Список заметок пустой")
        selectArch()
    }

    println("Просматриваем содержимое архива")

    println("Для просмотра заметки введите ее номер")

    val scan = Scanner(System.`in`)

    println(archieve.showAllNotes())
    while (true) {
        var noteID = scan.nextLine().toInt()
        when (noteID) {
            0 -> break
            else -> {
                archieve.chooseNote(noteID)
                println("Для выхода из заметки нажмите 0")
            }
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