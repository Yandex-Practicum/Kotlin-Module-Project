class MenuItem(
    val text: String,
    val isActive: Boolean = false,
    val isExecute: Boolean = false,
    val action: () -> Unit = {}
) {
}
// Создать класс меню
class Menu {

    fun showListMenu(menuPage: ListInterface) { // Создать список меню ListInterface
        println(menuPage.title)  // вывод показать страницу Меню
        var count: Int = 0
        val tempMap: MutableMap<Int, () -> Unit> = mutableMapOf() // Добавить лямбды ()->Unit
        val tempChoiceList: MutableList<String> = mutableListOf()
        for (i in menuPage.itemList) {
            if (i.isActive) {
                println("${count}. ${i.text}")
                tempMap.put(count, i.action)
                tempChoiceList.add(count, i.text)
                count++
            } else {
                println(i.text)
            }
            if (i.isExecute) {
                i.action.invoke()
            }
        }
        val userChoice = getIntUserResponse(count - 1, tempChoiceList)
        tempMap[userChoice]?.invoke()
    }

    // Добавить страницу с ответом  getIntUserResponse
    private fun getIntUserResponse(count: Int, choiceList: List<String>): Int {
        while (true) {
            val userResponse = scanner.nextLine()
            if (isInteger(userResponse) && (userResponse.toInt() in 0..count)) {
                return userResponse.toInt()
            } else {
                println("Ошибка. Введите число от 0..$count") // Вывести Ошибку ввода неправильного числа
                for ((countElement, i) in choiceList.withIndex()) {
                    println("${countElement}. $i")
                }
            }
        }
    }

    private fun isInteger(s: String): Boolean = s.toIntOrNull() != null
}