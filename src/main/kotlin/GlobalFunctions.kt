//test
fun create(name: String) {
    scanner.nextLine()
    if (name == "Архив") {
        println("Введите название архива:")
        val n = scanner.nextLine()
        repo[n] = mutableListOf()
    } else {
        println("Введите текст заметки:")
        val note = scanner.nextLine()
        repo[archiveName]?.add(note)
    }
}

fun showNote(index: Int) {
    while (true) {
        val text = repo[archiveName]!!.elementAt(index - 1)
        println("Заметка номер $index \nТекст:  $text")
        println("0.Добавить текст \n1.Выход")
        if (scanner.hasNextInt()) {
            when (scanner.nextInt()) {
                0 -> editNote(index - 1)
                1 -> break
                else -> println("Не верное число, повторите попытку")
            }
        } else {
            println("Неверный ввод ${scanner.next()} Введите число.")
            scanner.nextLine()
        }
    }
}

fun notes(index: Int) {
    archiveName = repo.keys.elementAt(index - 1)
    println("Архив : $archiveName")
    repo[archiveName]?.let { menu("Заметку", it, ::showNote, ::create) }
}

fun editNote(index: Int) {
    scanner.nextLine()
    println("Введите новый текст.")
    val text = scanner.nextLine()
    val temp = repo[archiveName]?.get(index)
    repo[archiveName]?.set(index, "$temp $text")
}