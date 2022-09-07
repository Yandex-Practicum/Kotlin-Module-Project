class Menu<T>(val header: String, val create: String, val dataList: ArrayList<T>) :
    PrintData() where T : Common {
    fun showMenu() {
        printHeader(header, true)
        println("0. Создать $create")

        dataList.forEachIndexed { index, element ->
            println("${index + 1}. ${element.name}")
        }

        println("${dataList.size + 1}. ВЫХОД")
    }
}