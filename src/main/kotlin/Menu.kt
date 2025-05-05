class Menu(val title : String, val options : List<String>, val select : (Int) -> Unit) {
    fun open() {
        while(true) {
            println(title)
            for (i in options.indices) println("$i. ${options[i]}")
            println("\nВыберите пункт:")
            val number = scanner.nextLine().trim().toIntOrNull()
            if (number == null) {
                println("Необходимо ввести число")
                continue
            }
            if (number !in options.indices) {
                println("Необходимо ввести число в диапозоне от 0 до ${options.size - 1}")
                continue
            }
            select(number)
            break
        }
    }
}