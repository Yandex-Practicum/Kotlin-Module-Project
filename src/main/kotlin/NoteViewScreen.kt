class NoteViewScreen(private val note: Note) : Screen {
    override fun show(repo: Repository, input: InputReader): NavCommand {
        println("Заметка: ${note.title}")
        println("------------")
        println(note.content)
        println("------------\n")

        val items = listOf(
            MenuItem("Назад") { NavCommand.Pop }
        )

        return Menu("", items, input).run()
    }
}