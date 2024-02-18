import Data.Archieve
import Data.Note
import PaigeLogic
import java.util.Scanner


val archievePage = PaigeLogic()

fun main() {
    while (true){
        println("1.Выбрать архив\n2.Создать архив\n3.Выйти из программы")
        var value = archievePage.getMenuCorrectInput()

        when(value){
            1 -> selectArch()
            2 -> createArch()
            3 -> break
            else -> println("Выберите элемент меню")
        }
    }
}

fun selectArch(){

    println("Список архивов")
    if (archievePage.showAllArchieves() == null) {
        println("Список архивов пустой")
        main()
    }

    println(archievePage.showAllArchieves())
    var archieveID = archievePage.getMenuCorrectInput()
    println(archievePage.chooseArchieve(archieveID)?.name)

    while (true){
        println("1.Выбрать заметку\n2.Создать заметку\n3.Выйти в меню Архивов")
        var noteID = archievePage.getMenuCorrectInput()

        when(noteID){
            1 -> archievePage.chooseArchieve(archieveID)?.let { selectNote(it) }
            2 -> archievePage.chooseArchieve(archieveID)?.let { createNote(it) }
            3 -> break
            else -> println("Выберите элемент меню")
        }
    }

}

fun createArch(){

    println("Создаем архив")

    println("Введите имя архива:")
    val archName: String = archievePage.getStringCorrectInput()

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


    println(archieve.showAllNotes())
    while (true) {
        var noteID = archievePage.getMenuCorrectInput()
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

    println("Введите название заметки:")
    val noteName = archievePage.getStringCorrectInput()

    println("Введите описание заметки:")
    val noteDescription = archievePage.getStringCorrectInput()

    archieve.addNote(Note(noteName, noteDescription))
    println("Заметка добавлена")
}