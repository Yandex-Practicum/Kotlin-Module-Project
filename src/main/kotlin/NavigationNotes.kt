import java.util.Scanner

class NavigationNotes {
    private val archives = Archives()

    fun printMenu() {
        while (true) {
            println("1. Список архивов\n2. Создать архив\n3. Выход")
            when (getUserInput("Введите команду:")) {
                "1" -> archives.printListArchives()
                "2" -> archives.createArchive()
                "3" -> {
                    println("Выход")
                    break
                }
                else -> println("Вы ввели неверную команду, попробуйте снова.")
            }
        }
    }

    private fun getUserInput(prompt: String): String {
        println(prompt)
        return Scanner(System.`in`).nextLine().trim()
    }
}