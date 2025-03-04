object MenuHelper {
    fun getUserOption(prompt: String, minOption: Int, maxOption: Int): Int {
        while (true) {
            println(prompt)
            val input = readLine()
            val option = input?.toIntOrNull()
            if (option != null && option in minOption..maxOption) {
                return option
            }
            println("Некорректный ввод! Пожалуйста, введите число от $minOption до $maxOption.")
        }
    }
}