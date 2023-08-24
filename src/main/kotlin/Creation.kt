class Creation {
    companion object {
        fun createArchive() {
            println("=======================\nВведите название архива\n" +
                    "=======================")
            val newArchive = Archive(Input.inputString())
            Archives.archives.add(newArchive)
            println("Архив '${newArchive.name}' создан")
        }

        fun createNote(): Note {
            println("Введите название заметки")
            val nameNote = Input.inputString()
            println("Текст заметки")
            val textNote = Input.inputString()
            return Note(nameNote, textNote)
        }

    }
}