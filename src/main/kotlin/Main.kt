import java.util.Scanner

const val EMPTY_STRING_NUMBERS: Int = 25       // // количество пустых строк для имитации нового экрана консоли

var archiveList: ArchiveList = ArchiveList()

fun main(args:Array<String>) {

    archiveList.showMenu()

    for (i in 0..EMPTY_STRING_NUMBERS) {
        println()
    }
    println("Выполнение программы завершено")


}
