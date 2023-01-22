class OpenNote(
    nextScreens: (AllScreens, Any?) -> Unit, exitScreen: () -> Unit, val arch: Arch
) : Screen(nextScreens, exitScreen) {
    override fun printContent() {
        val title = if (arch.listNote.size == 0) {
            "Заметок нет\n" +
                    "Введите цифру в зависимости от выполняемого действия"
        } else {
            "Для выбора заметки ввевиде ее порядковый номер \n" +
                    "Введите цифру в зависимости от выполняемого действия"
        }
        val menu = mutableListOf(
            "Вернуться назад",
            "Создать заметку"
        )

        arch.listNote.forEach {
            menu.add(it.name)

        }

        navigationInput2(
            title,
            menu
        ) { num ->
            when (num) {
                1 -> {
                    exit()
                }
                2 -> {
                    nextScreens(AllScreens.CREATE_NOTE, arch)
                }
                else -> {
                    nextScreens(AllScreens.VIEW_NOTE, arch.listNote[num-3])
                }
            }
        }

    }
}