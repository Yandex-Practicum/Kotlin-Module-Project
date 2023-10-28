import java.util.Scanner
import kotlin.system.exitProcess


fun main(args: Array<String>) {
    val archiveList = mutableListOf<Archive>()
    val scanner = Scanner(System. `in`)
    val menu = Menu()
    fun numError() {
        println("Некорректное значение, попробуйте снова")
    }
    fun createArchive() {
        println("Введите название архива:")
        while (true) {
            val name = Scanner(System.`in`).nextLine()
            if (name.isNullOrEmpty()) {
                println("Необходимо ввести название архива")
            } else {
                archiveList.add(Archive(name, mutableListOf()))
                return
            }
        }


    }

    while (true) {
        menu.archiveMenu(archiveList)
        val nextLine = scanner.nextLine()
        if (nextLine.toIntOrNull() == null) {
            println("Необходимо ввести цифру")
        } else {
            val command = nextLine.toInt()
            when {
                (command > archiveList.size + 1 || command < 0) -> numError()
                (command == archiveList.size + 1) -> exitProcess(0)
                (command == 0) -> createArchive()
                (command > 0 && command <= archiveList.size) -> archiveList[command - 1].showNotes(archiveList[command - 1], archiveList)
            }
        }
    }

}