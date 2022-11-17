class Archive(override val id: Int, override val name: String) : MenuFields {

    private val menuArchive: MutableList<MenuFields> = mutableListOf(
        Note(0, "Вернуться в главное меню", ""),
        Note(1, "Создать заметку", "")
    )

    override fun start() {
        while (true) {
            if (NaviFunctions.push(
                    menuArchive,
                    "Меню архива",
                    "заметку",
                    "Возвращаемся в главное меню"
                )
            )
                return
        }
    }
}