class InputCheck {

    fun inputAndCheck():Int {
        val m = readln()
        if (isNumeric(m)) {
            val n = m.toInt()
            return n
        }
        return -1
    }

    fun isNumeric(toCheck: String): Boolean {
        return toCheck.all { char -> char.isDigit() }
    }


}