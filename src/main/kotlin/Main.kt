fun main(args: Array<String>) {
    val archiveSelection = ArchiveSelection()
    var command: String = ""
    var result: Boolean

    while(true){
        archiveSelection.printMenu()
        command = archiveSelection.getUserCommand()

        if(!isInt(command)) {
            println("Ошибка: надо ввести целое число!")
            continue
        }
        if(command.toInt() > (archiveSelection.menuCommandMap.size - 1)) {
            println("Ошибка: такого пункта меню нет. Попробуйте еще раз!")
            continue
        }
        if(command.toInt() <0) {
            println("Ошибка: число должно быть целым положительным, ведь это номер пункта меню!")
            continue
        }
        result = archiveSelection.menuCommandMap[command.toInt()]!!.invoke()
        when (result) {
            true -> continue
            false -> break
        }
    }
}
fun isInt(str: String) = try {
    str.toInt()
    true
} catch (e: NumberFormatException) {
    false
}
