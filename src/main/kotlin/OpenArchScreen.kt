class OpenArchScreen(
    val arches: List<Arch>,
    nextScreens: (AllScreens, Any?) -> Unit, exitScreen: () -> Unit
) : Screen(nextScreens, exitScreen) {
    override fun printContent() {
        val menu = mutableListOf(
            "Вернуться назад",
        )

        arches.forEach {
            menu.add(it.name)
        }

        navigationInput2(
            "Для выбора архива ввевиде его порядковый номер \n" +
                    "Введите цифру в зависимости от выполняемого действия",
            menu
        ) { num ->
            when (num) {
                1 -> {
                   exit()
                }
                else -> {
                    nextScreens(AllScreens.OPEN_NOTE, arches[num - 2])
                }
            }
        }
    }
}