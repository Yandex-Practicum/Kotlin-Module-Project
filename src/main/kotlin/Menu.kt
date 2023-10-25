class MenuItem(
    val text: String,
    val isActive: Boolean = false,
    val isExecute: Boolean = false,
    val action: () -> Unit = {}
) {
}

class Menu {

    fun showListMenu(menuPage: ListInterface) {
        println(menuPage.title)
        var count: Int = 0
        val tempMap: MutableMap<Int, () -> Unit> = mutableMapOf()
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

    private fun getIntUserResponse(count: Int, choiceList: List<String>): Int {
        while (true) {
            val userResponse = scanner.nextLine()
            if (isInteger(userResponse) && (userResponse.toInt() in 0..count)) {
                return userResponse.toInt()
            } else {
                println("Ошибка. Введите число от 0..$count")
                for ((countElement, i) in choiceList.withIndex()) {
                    println("${countElement}. $i")
                }
            }
        }
    }

    private fun isInteger(s: String): Boolean {
        return s.toIntOrNull() != null
    }

}