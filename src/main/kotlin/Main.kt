fun main() {
    println("Добро пожаловать в приложение 'Заметки'")
    val archives = Archives()

    while(true) {
        println("Введите команду: \n 0. Выход \n 1. Выбор архива")

        val command = Utils.commandChecker()

        when(command){
            1 -> {
                archives.archivesMenu()
            }
            0 -> {
                println("Выход")
                return
                }
            else -> println("Ошибка: выберите команду из списка")
                }
        }
    }

