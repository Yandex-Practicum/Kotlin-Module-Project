class ViewNote(
    nextScreens: (AllScreens, Any?) -> Unit, exitScreen: () -> Unit, val note: Note
) : Screen(nextScreens, exitScreen) {
    override fun printContent() {
        println(
            "Название заметки ${note.name} \n" +
                    "Текст заметки:\n" +
                    " ${note.content}"
        )
        navigationInput2(
            "",
            mutableListOf(
                "Выйти",
            )
        ) { num ->
            when (num) {
                1 -> {
                   exit()
                }
            }
        }
    }
}