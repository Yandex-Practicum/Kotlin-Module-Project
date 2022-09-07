class Menu<T>(
    private val header: String,
    private val create: String,
    private val dataList: ArrayList<T>
) :
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