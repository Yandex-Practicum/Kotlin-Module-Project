class IOHandler {

    fun showList(title: String, items: List<String>, footer: String, createOp: String) {
        println(title)
        println(createOp)
        if (items.isNotEmpty()) {
            for (i in items.indices) {
                println("${i + 1}. ${items[i]}")
            }
        } else {
            println("Элементов нет.")
        }
        println(footer)
    }

    fun getUserChoice(): Int? {
        return readlnOrNull()?.toIntOrNull()
    }

    fun showMessage(message: String) {
        println(message)
    }
}