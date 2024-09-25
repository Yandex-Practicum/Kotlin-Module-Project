
class Navigator {
    fun showMenu(name: String, listOfOptions: List<Pair<String, MenuExecutable>>) {
        while (true) {
            println("Добро пожаловать в меню $name")
            listOfOptions.forEachIndexed { index, option ->
                println("${index + 1}. ${option.first}")
            }
            println("0. Выход")

            val input = getNumInput()
            if (input == 0) {
                return
            } else if (input in 1..listOfOptions.size) {
                listOfOptions[input - 1].second.executeOption()
            }
        }
    }

}


