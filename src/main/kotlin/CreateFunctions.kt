fun createArchive(menuWithArchives: MutableList<Archive>) {
    val namesOfArchives = menuWithArchives.map { it.name }
    println("Введите название архива  или \"выход\" чтобы выйти из создания архива")
    val input = checkName(namesOfArchives, TypeOfMenu.ARCHIVE)
    if (!input.equals("выход", true)) {
        val newNotes: MutableList<Note> = mutableListOf()
        menuWithArchives.add(Archive(input, newNotes))
    } else {
        println("\nОтмена создания архива\n")
    }
}
fun createNote(menuWithNotes: MutableList<Note>) {

    println("Введите название заметки или \"выход\" чтобы выйти из создания заметки")
    val namesOfNotes = menuWithNotes.map { it.name }
    val input = checkName(namesOfNotes, TypeOfMenu.NOTE)
    if (!input.equals("выход", true)) {
        println("Введите содержимое заметки")
        var content = readln()
        while (content.isBlank()) {
            println("Содержимое заметки не может быть пустым\nВведите содержимое заметки")
            content = readln()
        }

        menuWithNotes.add(Note(input, content))
    } else {
        println("Отмена создания заметки")
    }
}