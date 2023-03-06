
fun createArchive(): Archive {

    println("Введите название архива:")

    while (true) {
        val input = readLine()

        // делаем проверки
        when {
            input == null -> println("Упс. Что-то пошло не так. Попробуйте еще раз.")
            input.isEmpty() -> println("Ничего не введено. Попробуйте еще раз.")
            else -> return  Archive(input)
        }
    }
}