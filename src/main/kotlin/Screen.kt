import InputAndChecking.Companion.inputString
import InputAndChecking.Companion.intOrString
import kotlin.system.exitProcess

open class Screen {
    companion object {
        fun mainScreen() {
            println("=======================\nМеню: \n1.Создать архив \n2.Мои архивы \n3.Выход" +
                    "\n=======================")
            when (InputAndChecking.inputInt()) {
                1 -> {Creation.createArchive()}
                2 -> archivesScreen()
                3 -> exitProcess(1)
                else -> println("Введите правильную команду")
            }
        }
        private fun archivesScreen() {
            println("Список архивов: ")
            Archives.viewArchivesList()
            println("\nВыберите архив или введите 'Выход' для перехода в предыдущее меню")
            val inputInt = InputAndChecking.inputInt()
            if (inputInt > Archives.archives.size) {
                println("Неверный номер архива")
            } else {
                menuInArchiveScreen(inputInt)
            }
        }
        private fun listNotesScreen(indexArchive: Int) {
            println("Список заметок архива '${Archives.archives[indexArchive].name}': ")
            for (i in Archives.archives[indexArchive].noteList.indices) {
                println("${i}.${Archives.archives[indexArchive].noteList[i].header}")
            }
            println("\nВыберите заметку или введите 'Выход' для выхода")
            var inputInt = InputAndChecking.inputString()
            var ll: Int = 0
            if (InputAndChecking.isInt(inputInt)) {
                ll - inputInt.toInt()
                if (ll > Archives.archives[indexArchive].noteList.size) {
                    println("Неверный номер архива")
                } else {
                    Note.viewNote(Archives.archives[indexArchive].noteList[ll], indexArchive)
                }
            } else if(inputInt.lowercase() == "выход") {
                archivesScreen()
            } else {
                println("Ошибка ввода")
            }
        }
        fun menuInArchiveScreen(indexArchive: Int) {
            println("=======================\nМеню заметок архива " +
                    "'${Archives.archives[indexArchive].name}'" +
                    " \n1.Создать заметку \n2.Посмотреть заметки " +
                    "\n3.Выход\n=======================\n")
            when (InputAndChecking.inputInt()) {
                1 -> Archives.archives[indexArchive].noteList.add(Creation.createNote())
                2 -> listNotesScreen(indexArchive)
                3 -> archivesScreen()
            }
            menuInArchiveScreen(indexArchive)
        }

    }
}