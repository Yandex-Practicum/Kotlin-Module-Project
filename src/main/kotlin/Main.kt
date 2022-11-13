fun main() {

    println(
        "Вы пользуетесь приложением для создания, хранения и чтения заметок. " +
                "Заметки распределяются по архивам. " +
                "Вы можете создавать и просматривать архивы, а также добавлять, изменять и просматривать заметки внутри архивов."
    )

    val archives: MutableList<Archive> = mutableListOf()
    val menuNavigator = MenuNavigator(archives)
    menuNavigator.demonstrateScreen(Screen.AllArchives)

}

