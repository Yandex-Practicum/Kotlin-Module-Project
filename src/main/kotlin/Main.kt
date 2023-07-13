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
                userInput.equals("1") -> {
                    val archive = Archive()
                    archive.createArchive()
                    archiveList.add(archive)
                }
                userInput.equals("2") -> {
                    if (archiveList.size > 0) chooseArchive(archiveList) else println("Список архивов пуст.")
                }
                userInput.equals("3") -> return
                else -> println("Неверный ввод, попробуйте снова.")
            }
        }
    }

    private fun chooseArchive(archiveList: ArrayList<Archive>) {
        println("\nВыберите архив:")
        for (i in 0..archiveList.size - 1) {
            println("${i + 1}. ${archiveList[i].name}")
        }
        val userInput = Scanner(System.`in`).nextLine()
        for (i in 0..archiveList.size - 1) {
            if (userInput.equals((i + 1).toString())) {
                archiveList[i].openArchive()
                return
            }
        }
        println("Архив с таким номером не найден, попробуйте снова.")
    }
}

fun main() {
    val menuManager = MenuManager()
    menuManager.startMenu()
}
