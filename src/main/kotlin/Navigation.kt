
fun menu(
    header: String,
    menuList: Iterable<String?>,
    openCreationMenu: (header: String) -> Unit,
    openNextMenu: (input: Int) -> Unit
    ) {
    while (true) {

        println("0. Создать $header")

        var n = 1
        menuList.forEach { println("${n++}. $it") }

        println("$n. Выход")

        if (scanner.hasNextInt()) {

            when (val input = scanner.nextInt()) {
                0 ->  openCreationMenu(header)
                in 0 until n -> openNextMenu(input)
                n -> {
                    scanner.nextLine()
                    break
                }
                else -> incorrectInput()
            }
        } else nonNumericInput()
    }
}

fun menuNotes(input: Int) {
    scanner.nextLine()

    archiveName = archives.keys.elementAt(input - 1)
    println("Открылся архив:\n'$archiveName'")

    menu("заметку", archives[archiveName]!!, ::creationMenu,::showNote)
}

fun creationMenu(header: String) {

    if (header == "архив") createArchive()
    else createNote()

    while (true) {
        println("0. Создать еще $header\n1. Назад")
        if (scanner.hasNextInt()) {

            when (scanner.nextInt()) {
                0 -> {
                    if (header == "архив") createArchive()
                    else createNote()
                }
                1 -> {
                    scanner.nextLine()
                    break
                }
                else -> incorrectInput()
                }
        } else nonNumericInput()
    }
}
fun incorrectInput() {
    println("Такого пункта в меню пока нет. Попробуйте еще раз")
    scanner.nextLine()
}

fun nonNumericInput() {
    println("Вы ввели не цифру. Попробуйте еще раз")
    scanner.nextLine()
}