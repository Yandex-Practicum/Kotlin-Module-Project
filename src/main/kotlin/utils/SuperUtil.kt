package utils

fun readIntInput (name: String, min: Int, max: Int) : Int {
    while (true) {
        println(name)
        val input = readln().toIntOrNull()
        if (input != null && input in min..max) {
            return input
        } else {
            println("Введите корректное число!")
        }
    }
}

fun readNonBlankString(name: String) : String {
    while (true) {
        println(name)
        val input = readln().trim()
        if (input.isBlank()) {
            println("Поле не может быть пустым")
        } else return input
    }
}
fun showMenu(options: List<String>, title: String) : Int {
    println(title)
    options.forEachIndexed { index, option -> println("${index + 1}. $option") }
    return readIntInput("Выберите пункт меню: ", 0, options.size)
}