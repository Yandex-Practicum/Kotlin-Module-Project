open class InputKey() {

    fun inputInt(int: Int): Int {
        var out = -1
        var bool = false
        while (!bool) {
            val textInput = readLine()
            try {
                if (textInput != null && textInput.toInt() < (int + 1)&&textInput.toInt()>=0) {
                    out = textInput.toInt()
                    bool = true
                } else if (textInput != null) {
                    println("Введите числа из диапазона меню")
                }
            } catch (e: Exception) {
                println("Введите номер строки меню и повторите ввод:")
            }
        }
        return out
    }

    fun inputStr(): String {
        return readLine().toString()
    }


}