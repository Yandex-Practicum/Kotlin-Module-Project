object InputHandler {
    fun readValidInput(prompt: String, validator: (String) -> Boolean): String {
        while (true) {
            println(prompt)
            val input = readlnOrNull()?.trim() ?: ""
            if (validator(input)) return input
            println("Некорректный ввод, попробуйте снова")
        }
    }
}