class Utils {

    fun validateInput(input: String?): Boolean {
        when {
            input == null -> {
                println("Упс. Что-то пошло не так. Попробуйте еще раз.")
                return false
            }
            input.isEmpty() -> {
                println("Ничего не введено. Попробуйте еще раз.")
                return false
            }
        }

        return true
    }

    fun viewDigitError() {
        println("Неверное значение. Попробуйте ещё раз")
    }
}