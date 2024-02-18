import java.util.Scanner
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    val archiveList = mutableListOf<Archive>()
    val scanner = Scanner(System.`in`)
    val menu = Menu()
    while (true) {
        menu.archiveMenu(archiveList)
        val nextLine = scanner.nextLine()
        if (nextLine.toIntOrNull() == null) {
            println("Введите цифру")
        } else {
            val command = nextLine.toInt()
            when {

                (command > archiveList.size + 1 || command < 0) -> println("Некорректный ввод, попробуйте снова")
                (command == archiveList.size + 1) -> exitProcess(0)
                (command == 0) -> {
                    println("Введите название архива")
                    val name = scanner.nextLine()
                    if (name.isNullOrEmpty()) {
                        println("Название не может быть пустым")
                    } else {
                        archiveList.add(Archive(name, mutableListOf()))
                    }
                }

                (command > 0 && command <= archiveList.size) -> archiveList[command - 1].showNotes(
                    archiveList[command - 1],
                    archiveList
                )

            }
        }
    }
}