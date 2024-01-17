import java.util.Scanner

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
    println("1.Выбрать заметку\n2.Создать заметку")

    val scan = Scanner(System.`in`)

    when(scan.nextLine().toInt()){
        1 -> selectNote()
        2 -> createNote()
    }
}

fun createArch(){
    println("Создать архив")
}

fun selectNote(){
    println("Выбираем заметку")
}

fun createNote(){
    println("Создаем заметку")
}