abstract class Commander {
    var menuNumb: Int = 0
    var choice: Int = 0
    var noteText: MutableMap<Int, Note> = HashMap()

    abstract fun command()

    fun commandReader(): Int {
        val comChoice: Int
        while (true) {
            val reader = readLine()
            if (reader != null) {
                if (reader.toIntOrNull() != null) {
                    comChoice = reader.toInt()
                    return comChoice
                } else println("Введите один из пунктов меню в виде числа")
            }
        }
    }

    abstract fun printing()
}