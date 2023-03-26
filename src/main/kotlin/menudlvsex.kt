import java.util.Scanner
import kotlin.system.exitProcess


val scanner: Scanner = Scanner(System.`in`)

fun logika(


) {

    val arhivAd = inArhive()
    val zametki = spisZmt()

    while (true) {


        if (scanner.hasNextInt()) {
            val scanInt = scanner.nextInt()
            if (scanInt < 7) {

                when (scanInt) {
                    0 -> arhivAd.spiSka()
                    1 -> println(arhivAd.arhivArrayList.toString())
                    2 -> exitProcess(-1) //выход из программы
                    3 -> zametki.dodZamet() //("создать заметку")
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

