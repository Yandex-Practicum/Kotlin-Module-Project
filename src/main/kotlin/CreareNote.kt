class CreareNote (
    nextScreens: (AllScreens, Any?) -> Unit, exitScreen: () -> Unit, val arch: Arch
) : Screen(nextScreens, exitScreen)  {
    override fun printContent() {
        println("Создание Заметки")
        println("Введите название Заметки и нажмите ENTER")
        val note = readLine()?.trim()
        if (checkName(note)) {

        } else {
            println("Вы не ввели текст, попробуйте еще")
            printContent()
        }
        println("Введите текст заметки")
        val noteText = readLine()?.trim()
        if (checkName(noteText)) {
            println("Заметка $note успешно создан")
            arch.listNote.add(
                Note(
                    name = note!!,
                    noteText!!
                    )
            )
            exit()
        } else {
            println("Вы не ввели текст, попробуйте еще")
            printContent()
        }
    }
}