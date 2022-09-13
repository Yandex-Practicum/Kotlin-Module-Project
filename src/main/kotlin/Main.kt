fun getFromInput(query: String): String {
    var input: String? = null
    while (input == null || input == "") {
        print(query)
        input = readLine()
    }
    return input
}

fun main() {
    val title = "\"ЗАМЕТКИ\""
    println("*** Добро пожаловать в консольное приложение $title ***\n${Style.setIndention(4)}Здесь мы можем:")
    println("${Style.setIndention(11)}- создавать и просматривать заметки")
    println("${Style.setIndention(11)}- создавать и просматривать архивы с заметками")
    println("${Style.setIndention(11)}- переименовывать и удалять созданные элементы\n")
    println("${Style.setIndention(4)}Пока ничего нет, но давайте что-нибудь создадим\n")

    val navigator = Navigator(Folder("Корневой каталог", null))
    navigator.showCommands()
    while (navigator.isRunning) {
        val input = getFromInput(navigator.path())
        if (input.count() >= navigator.getLenghtOfCommand()) {
            navigator.handleInput(input)
        } else {
            println("Недопустимый ввод. Введите \"${navigator.getCommandHelp()}\" для справки")
        }
    }
    println("Работа приложения $title завершена.\nХорошего дня!")
}
