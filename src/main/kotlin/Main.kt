import Data.Archieve
import Data.Note
import java.util.Scanner

val archievePage = ArchievePage()

fun main(args: Array<String>) {

    val scan = Scanner(System.`in`)

    while (true){
        println("1.Выбрать архив\n2.Создать архив\n3.Выйти из программы")

        when(scan.nextLine().toInt()){
            1 -> selectArch()
            2 -> createArch()
            3 -> break
        }

    }
}

fun selectArch(){

    val scan = Scanner(System.`in`)

    while (true) {
        println("1.Выбрать заметку\n2.Создать заметку\n3.Выйти в главное меню")
        when (scan.nextLine().toInt()) {
            1 -> selectNote()
            2 -> createNote()
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
    archievePage.showAllArchieves()
}

fun selectNote() {
    val scan = Scanner(System.`in`)
    println("Просматриваем содержимое заметки")
    while (true) {
        when (scan.nextLine().toInt()) {
            1 -> break
        }
    }
}

fun createNote(){
    println("Создаем заметку")
}