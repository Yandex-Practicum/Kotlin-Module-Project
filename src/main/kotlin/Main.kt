const val CHOOSE_ARCHIVE = "1 - Выбор архива"
const val CREATE_ARCHIVE = "2 - Создание архива"
const val EXIT = "0 - Выход"

fun main() {
    val scanner = Scanner(System.`in`)
    println(CHOOSE_ARCHIVE + "\n" +
            CREATE_ARCHIVE + "\n" +
            EXIT)

    println(scanner.nextLine())
}
