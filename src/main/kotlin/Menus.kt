class Menus {

    fun mainMenu() {
        while (true) {
            println("-----------------------\n     ГЛАВНОЕ МЕНЮ \n-----------------------")
            println("Введите цифру для выбора действия:  \n 1. Создать архив. \n 2. Список архивов. \n 3. Завершение работы.")
            val sc = UserInput().menuInput(4)
            when (sc) {
                1 -> Archive().createArchive()
                2 -> archivesMenu()
                3 -> { println("Спасибо что воспользовались этой программой! Досвидания!")
                    break
                }
            }
        }
    }

    private fun archivesMenu() {
        val num = allArchivesList.size
        if (allArchivesList.isEmpty()) {
            println("На данный момент не создан ни один архив!")
        } else {
            while (true) {
                println("-----------------------\n      МЕНЮ АРХИВОВ \n-----------------------")
                Archive().allArchives()
                println("Введите номер архива:")
                for (i in allArchivesList.indices) {
                    println(" ${i + 1}. ${allArchivesList[i].archiveName}")
                }
                println(" ${num + 1}. Назад.")
                when (val sc = UserInput().menuInput(num+2)) {
                    in 1 until num + 1 -> singleArchiveMenu(allArchivesList[sc - 1])
                    num + 1 -> break
                }
            }
        }
    }

    private fun singleArchiveMenu (archive: Archive) {
        while (true) {
            println("-----------------------\n  МЕНЮ АРХИВА \"${archive.archiveName}\" \n-----------------------")
            println("Введите цифру для выбора действия:  \n 1. Добавить заметку в архив. \n 2. Список заметок архива. \n 3. Назад.")
            val sc = UserInput().menuInput(4)
            when (sc) {
                1 -> Note().createNote(archive)
                2 -> Note().allNotes(archive)
                3 -> break
            }
        }
    }
}
