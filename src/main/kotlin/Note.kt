data class Note(
    val name: String,
    val text: String) {


    fun openNote() {
        println("Просмотр заметки $name")
        println(text)
        println("Введите команду: \n 0. Выход")
        val command = Utils.commandChecker()

        when {
            command == 0 -> {
                println("Выход")
                return
            }
            else -> println("Ошибка: выберите команду из списка")
        }
    }
}