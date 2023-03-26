import java.util.Scanner
import kotlin.system.exitProcess



val scanner = Scanner(System.`in`)

fun logika(


) {

    val arhivAd = inArhive()
    val zametki = spisZmt()
    //val testarhiv = Onearhiv("fggg")
    while (true) {



        if (scanner.hasNextInt()) {
            val scan = scanner.nextInt()
            if (scan < 7) {

                when (scan) {
                    0 -> arhivAd.nazvanitArhiv()
                    1 -> println(arhivAd.arhivList.toString())
                    2 -> exitProcess(-1) //выход из программы
                    3 -> zametkaVvod() //("создать заметку")
                    4 -> println(zametki.zamArrayList.toString()) //("Выбор из списка заметок")
                    5 -> exitProcess(-1) //выход в меню 1
                    6 -> exitProcess(-1) //выход в меню 2
                }
            } else {
                println("Введите пункт меню")
                scanner.next()
            }
        } else {
            println("Введите номер пункта который хотите выбрать")
            scanner.next()
        }

    }
}



//fun viborspiska() {}

    //println("Выберете из списка:")

//}