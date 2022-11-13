import java.util.*

class Menu
 {
    private val archives: MutableList<Archive> = mutableListOf()


    fun showMenuArchive() {

        println("0. Создать архив")
        archives.forEachIndexed { index, Archive -> println("${index + 1}. ${Archive.name}") }
        println("${archives.size + 1}. Выход")

        println("Введите цифрой нужную команду")
        archiveLogic(getCommand())
    }

    private fun createArchive() {
        println("Как назовем новый архив?")
        val nameArchive = Scanner(System.`in`).nextLine()
        archives.add(Archive(nameArchive, mutableListOf()))
        println("Создан новый архив с именем $nameArchive")
        showMenuArchive()
    }

    private fun openArchive(archive:Archive) {
        archive.showArchive()
        showMenuArchive()
    }
    private fun checkNumber(string:String): Boolean {
        return try {
            string.toInt()
            false
        } catch (e: NumberFormatException) {
            true
        }
    }
    private fun getCommand(): Int {
        var number: String = Scanner(System.`in`).nextLine()
        while (true)
            number = if (checkNumber(number)) {
                println("Неправильный ввод, Вы ввели символ или слово. Введите цифру")
                Scanner(System.`in`).nextLine()
            } else if ((number.toInt() > (archives.size + 1)) or (number.toInt() < 0)) {
                println("Неправильный ввод, такого пункта нет в меню. Введите цифру")
                Scanner(System.`in`).nextLine()
            } else return number.toInt()
    }

    private fun archiveLogic(number: Int) {
        when (number) {
            0 -> {
                createArchive()
            }
            (archives.size + 1) -> {
                archives.clear()
                return
            }
            else -> {
                openArchive(archives[number-1])
            }
        }
    }
}