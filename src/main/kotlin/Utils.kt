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

fun selectAction(caption: String, menuActions: List<String>, onSelect: (Int) -> Unit) {
    while (true) {
        println("$caption:")
        for (i in menuActions.indices) println("${i}. ${menuActions[i]}")
        println("${menuActions.size}. Выход")
        var value: String
        while (true) {
            value = Scanner(System.`in`).nextLine()
            if (value.isNotEmpty() && isNumeric(value) && value.toInt() in 0..menuActions.size) {
                break
            }
            println("Пожалуйста, выберите пункт из меню.\n")
        }
        if (value.toInt() == menuActions.size) break
        else onSelect.invoke(value.toInt())
    }
}

fun getNewItem(caption: String): String {
    println(caption)
    return getStringInput()
}