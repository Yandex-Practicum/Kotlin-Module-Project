class CreateArchScreen(
    val addArch: (Arch) -> Unit,
    nextScreens: (AllScreens, Any?) -> Unit,
    exitScreen: () -> Unit
) : Screen(nextScreens, exitScreen) {
    override fun printContent() {
        println("Создание Архива")
        println("Введите название Архива и нажмите ENTER")
        val arch = readLine()?.trim()
        if (checkName(arch)) {
            println("Архив $arch успешно создан")
            addArch(
                Arch(
                    name = arch!!,
                    listNote = mutableListOf()
                )
            )
            exit()
        } else {
            println("Вы не ввели текст, попробуйте еще")
            printContent()
        }
    }
}


fun checkName(name: String?): Boolean {
    return !name?.trim().isNullOrEmpty()
}