import java.util.Scanner
import kotlin.system.exitProcess


val scanner = Scanner(System.`in`)

fun Logika() {

    val arhivAd = inArhive()
    while (true) {

        if (scanner.hasNextInt()) {
            val scan = scanner.nextInt()
            if (scan in 0..2) {
                when (scan) {
                    0 -> arhivAd.nachalo()
                    1 -> println("ghbdtn")
                    2 -> exitProcess(-1) //выход из программы

                }
            } else if (scan in 3..5) {
                when (scan) {

                    3 -> println("makeZmtka()") //("создать заметку")
                    4 -> println("makeArive()") //("Выбор из списка заметок переделать")
                    5 -> exitProcess(-1) //выход в меню 1
                }
            } else {
                println("Введите пункт меню")
                scanner.next()
            }
        } else {
            println("Введите номер пункта который хотите выбрать")
            scanner.next()
        }
        break
    }
}
