class Menu<T>(private val typeOfData: List<T>) where T : TypeOfData {
    fun showMenu(): MutableList<Int> {
        val outputFromElement: MutableList<Int> = mutableListOf()
        typeOfData.forEachIndexed { index, element ->
            println("$index. ${element.name}")
            outputFromElement.add(index)
        }
        println("${typeOfData.lastIndex + 1}. Выход\n")
        return outputFromElement
    }
}