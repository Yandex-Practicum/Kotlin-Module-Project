class ContentMenu(note: Note): Menu() {
    val text = note.text
    override var commands = mutableListOf<Command>()
    override fun createListCommandAndView() {
        println(text)
        commands = mutableListOf<Command>().apply {
            add(Command("Выйти") { exit() })
        }
        view(commands)
    }

}