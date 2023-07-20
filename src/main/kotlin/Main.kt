import java.util.Scanner

class MenuManager(private val scanner: Scanner) {
    private val archiveList = ArrayList<Archive>()

    fun startMenu() {
        while (true) {
            println("\n1. Создать новый архив\n2. Открыть существующий архив\n3. Выход")
            when (scanner.nextLine()) {
                "1" -> {
                    val archive = Archive(scanner)
                    if (archive.createArchive()) {
                        archiveList.add(archive)
                    }
                }
                "2" -> {
                    if (archiveList.isNotEmpty()) selectArchive() else println("Список архивов пуст.")
                }
                "3" -> return
                else -> println("Некорректный ввод, попробуйте снова.")
            }
        }
    }

    private fun selectArchive() {
        println("\nВыберите архив:")
        for (i in 0 until archiveList.size) {
            println("${i + 1}. ${archiveList[i].name}")
        }
        val userInput = scanner.nextLine().toIntOrNull()
        if (userInput != null && userInput in 1..archiveList.size) {
            archiveList[userInput - 1].openArchive()
        } else {
            println("Архива с этим номером не найдено, пожалуйста, попробуйте снова.")
        }
    }
}

fun main() {
    val scanner = Scanner(System.`in`)
    val menuManager = MenuManager(scanner)
    menuManager.startMenu()
}
