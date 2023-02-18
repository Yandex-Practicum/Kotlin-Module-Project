class MenuUtils : Menu() {
        override val title: String = "Список архивов"
        override val dataList: MutableList<MenuData> = mutableListOf(
            MenuData("Создать архив", action = { ActionMenu.addArchive(scanner) }),
            MenuData("Выход", action = {exit()})
        )

        override fun exit(): Boolean {
            println("Всем спасибо, все свободны")
            return false
        }
    }
