class Creation {
    companion object {
        fun createArchive() {
            println("=======================\nВведите название архива\n" +
                    "=======================")
            val newArchive = Archive(InputAndChecking.inputString())
            Archives.archives.add(newArchive)
            println("Архив '${newArchive.name}' создан")
            Screen.menuInArchiveScreen(Archives.archives.lastIndex)
        }

        fun createNote(): Note {
            println("Введите название заметки")
            val nameNote = InputAndChecking.inputString()
            println("Текст заметки")
            val textNote = InputAndChecking.inputString()
            return Note(nameNote, textNote)
        }

    }
}