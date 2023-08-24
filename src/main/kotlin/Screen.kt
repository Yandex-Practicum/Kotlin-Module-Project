open class Screen {
    companion object {
        fun mainScreen() {
            println("=======================\nМеню: \n1.Создать архив \n2.Мои архивы \n3.Выход" +
                    "\n=======================")
            when (Input.inputInt()) {
                1 -> {
                    Creation.createArchive()
                }
                2 -> viewArchives()
                else -> println("Введите правильную команду")
            }
            mainScreen()
        }
        private fun viewArchives() {
            println("Список архивов: ")
            for (i in Archives.archives.indices) {
                println("${i}.${Archives.archives[i].name}")
            }
            println("\nВыберите архив или введите 0 для выхода")
            val l = Input.inputInt()
            if (l > Archives.archives.size) {
                println("Неверный номер архива")
            } else {
                menuInArchive(l)
            }
        }
        private fun listNotes(indexArchive: Int) {
            println("Список заметок: ")
            for (i in Archives.archives[indexArchive].noteList.indices) {
                println("${i}.${Archives.archives[indexArchive].noteList[i].header}")
            }
            println("\nВыберите заметку или введите 0 для выхода")
            val l = Input.inputInt()

            if (l > Archives.archives[indexArchive].noteList.size) {
                println("Неверный номер архива")
            }  else {
                viewNote(Archives.archives[indexArchive].noteList[l], indexArchive)
            }
        }
        private fun menuInArchive(indexArchive: Int) {
            println("\nМеню: \n1.Создать заметку \n2.Посмотреть заметки \n3.Выход\n")
            when (Input.inputInt()) {
                1 -> Archives.archives[indexArchive].noteList.add(Creation.createNote())
                2 -> listNotes(indexArchive)
                3 -> viewArchives()
            }
            menuInArchive(indexArchive)
        }
        private fun viewNote(note: Note, indexArchive: Int) {
            println("У Вас открыта заметка '${note.header}'")
            println(note.text)
            menuInArchive(indexArchive)
        }
    }
}