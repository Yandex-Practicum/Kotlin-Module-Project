class Screen {
    companion object {
        val indexArchive: Int = 0
        public fun mainScreen() {
            println("\nМеню: \n1.Создать архив \n2.Мои архивы \n3.Выход\n")
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
                println("${i + 1}.${Archives.archives[i].name}")
            }
            println("\nВыберите архив или введите 0 для выхода")
            val l = Input.inputInt()
            if (l > Archives.archives.size  && l == 0) {
                println("Неверный номер архива")
            } else {
                openArchive(l)
            }
        }

        private fun viewNotes(indexArchive: Int) {
            println("Список заметок: ")
            for (i in Archives.archives[indexArchive].noteList) {
                println("${i.header}")
            }
            println("\nВыберите заметку или введите 0 для выхода")
        }



        fun openArchive(indexArchive: Int) {
            println("\nМеню: \n1.Создать заметку \n2.Посмотреть заметки \n3.Выход\n")

            when (Input.inputInt()) {
                1 -> Archives.archives[indexArchive-1].noteList.add(Creation.createNote())
                2 -> viewNotes(indexArchive)
            }

        }
    }
}
