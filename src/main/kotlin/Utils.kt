// Функция для считывания ввода с проверкой на пустую строку
fun readInput(prompt: String): String? {
    println(prompt)
    return readLine()?.trim()?.takeIf { it.isNotEmpty() }
}