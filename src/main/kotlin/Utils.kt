import java.util.Scanner

fun isNumeric(toCheck: String): Boolean {
    return toCheck.all { char -> char.isDigit() }
}

fun getStringInput(): String {
    var value: String
    while (true) {
        value = Scanner(System.`in`).nextLine()
        if (value.isNotEmpty()) return value
    }
}

fun selectAction(caption: String, menuActions: List<String>): Int {
    println("$caption:")
    for (i in menuActions.indices) println("${i}. ${menuActions[i]}")
    println("${menuActions.size}. Выход")
    var value: String
    while (true) {
        value = Scanner(System.`in`).nextLine()
        if (value.isNotEmpty() && isNumeric(value) && value.toInt() in 0..menuActions.size) {
            return value.toInt()
        }
        println("Пожалуйста, выберите пункт из меню.")
    }
}

fun getNewItem(caption: String): String {
    println(caption)
    return getStringInput()
}