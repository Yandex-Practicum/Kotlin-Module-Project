import java.util.Scanner
import kotlin.system.exitProcess


val scanner: String = Scanner(System.`in`).nextLine()

fun Logika(

) {
2
    val arhivAd = inArhive()
    val zametki = spisZmt()

    when (scanner) {

        "0" -> arhivAd.spiSka()
        "1" -> println(arhivAd.arhivArrayList.toString())
        "2" -> exitProcess(-1) //выход из программы
        "3" -> zametki.dodZamet() //("создать заметку")
        "4" -> println(zametki.zamArrayList.toString()) //("Выбор из списка заметок")
        "5" -> return //выход в меню 1
        "6" -> return //выход в меню 2
    }

}

