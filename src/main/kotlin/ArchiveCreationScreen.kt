class ArchiveCreationScreen : Screen<Any?>() {
    override fun show() {
        print("Введите название нового архива: ")
        val name = scanner.nextLine()
        if (name.isEmpty()) {
            println("Название архива не может быть пустым.")
            return
        }
        if (archives.containsKey(name)) {
            println("Архив с таким именем уже существует.")
            return
        }
        archives[name] = mutableMapOf()
        currentArchive = name
        NoteMenu().show()
    }
}