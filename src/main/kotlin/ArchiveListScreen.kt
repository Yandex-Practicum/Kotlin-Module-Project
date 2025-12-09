class ArchiveListScreen : Screen {
    override fun show(repo: Repository, input: InputReader): NavCommand {
        val items = mutableListOf<MenuItem>()
        items.add(
            MenuItem("Создать архив") {
                NavCommand.Push(CreateArchiveScreen())
            }
        )
        repo.archives.forEach { archive ->
            items.add(
                MenuItem(archive.name) {
                    NavCommand.Push(NoteListScreen(archive))
                }
            )
        }
        items.add(
            MenuItem("Выход") {
                NavCommand.Exit
            }
        )
        return Menu("Список архивов:", items, input).run()
    }
}