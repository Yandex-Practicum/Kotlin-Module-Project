import jdk.nashorn.internal.objects.Global.println
import java.util.Scanner
import java.util.ArrayList

class MenuManager {
    fun startMenu() {
        val archiveList = ArrayList<Archive>()
        val scanner = Scanner(System.`in`)

        while (true) {
            println("\n1. Создать новый архив\n2. Открыть существующий архив\n3. Выход")
            val userInput = scanner.nextLine()
            when {
                userInput == "1" -> {
                    val archive = Archive()
                    if (archive.createArchive()) {
                        archiveList.add(archive)
                    }
                }
                userInput == "2" -> {
                    if (archiveList.size > 0) chooseArchive(archiveList) else println("Список архивов пуст.")
                }
                userInput == "3" -> return
                else -> println("Неверный ввод, попробуйте снова.")
            }
        }
    }

    private fun chooseArchive(archiveList: ArrayList<Archive>) {
        println("\nВыберите архив:")
        for (i in 0 until archiveList.size) {
            println("${i + 1}. ${archiveList[i].name}")
        }
        val userInput = Scanner(System.`in`).nextLine().toIntOrNull()
        if (userInput != null && userInput in 1..archiveList.size) {
            archiveList[userInput - 1].openArchive()
        } else {
            println("Архив с таким номером не найден, попробуйте снова.")
        }
    }
}

fun main() {
    val menuManager = MenuManager()
    menuManager.startMenu()
}

