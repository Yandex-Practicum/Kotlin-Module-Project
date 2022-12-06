
fun createNote() {
    scanner.nextLine()

    println("Введите текст заметки:")

    val note = scanner.nextLine()
    archives[archiveName]!!.add(note)

    println("Вы создали заметку: '$note'")
}

fun showNote (input: Int) {
    scanner.nextLine()

    while (true) {

        val noteText = archives[archiveName]!!.elementAt(input - 1)
        println("Просмотр заметки номер $input\n'$noteText'\n0. Изменить текст заметки\n1. Удалить заметку\n2. Назад")

        if (scanner.hasNextInt()) {
            when (scanner.nextInt()) {
                0 -> changeNote(input)
                1 -> { println("Заметка удалена\nВозвращаемся в список заметок архива - '$archiveName'")
                    archives[archiveName]!!.removeAt(input - 1)
                    scanner.nextLine()
                    break
                  }
                2 -> {
                    scanner.nextLine()
                    break
                }
                else -> incorrectInput()
            }
        } else nonNumericInput()
    }
}

fun changeNote (input: Int) {
    scanner.nextLine()
    println("Введите новый текст заметки:")
    val note = scanner.nextLine()
    archives[archiveName]!![input - 1] = note
}
