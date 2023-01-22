class StartScreen(nextScreens: (AllScreens, Any?) -> Unit, exitScreen: () -> Unit) :
    Screen(nextScreens, exitScreen) {
    override fun printContent() {
        navigationInput2(
            "Привет, хотите создать архив или открыть архив? \n" +
                    "Введите цифру в зависимости от выполняемого действия",
            mutableListOf(
                "Для того чтобы создать новый архив",
                "Для того чтобы открыть уже имеющийся архив ",
                "Выйти"
            )
        ) { num ->
            when (num) {
                1 -> nextScreens(AllScreens.CREATE_ARCH, null)
                2 -> nextScreens(AllScreens.OPEN_ARCH, null)
                3 -> {
                    exit()
                }
            }
        }
    }
}