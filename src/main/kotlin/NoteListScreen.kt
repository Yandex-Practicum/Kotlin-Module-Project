class NoteListScreen(private val archive: Archive) : Screen {
    override fun show(repo: Repository, input: InputReader): NavCommand {
        val items = mutableListOf<MenuItem>()

        items.add(
            MenuItem("Создать заметку") {
                NavCommand.Push(CreateNoteScreen(archive))
            }
        )

        archive.notes.forEach { note ->
            items.add(
                MenuItem(note.title) {
                    NavCommand.Push(NoteViewScreen(note))
                }
            )
        }

        items.add(
            MenuItem("Назад") {
                NavCommand.Pop
            }
        )

        return Menu("Архив: ${archive.name}\nСписок заметок:", items, input).run()
    }
}
