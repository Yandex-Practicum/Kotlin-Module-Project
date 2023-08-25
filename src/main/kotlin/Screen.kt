import InputAndChecking.Companion.inputString
import InputAndChecking.Companion.intOrString
import kotlin.system.exitProcess

open class Screen {
    companion object {
        fun mainScreen() {     // Основное меню после запуска программы
            println("=======================\nМеню: \n1.Создать архив \n2.Мои архивы \n3.Выход" +
                    "\n=======================")
            when (InputAndChecking.inputInt()) {
                1 -> {Creation.createArchive()}
                2 -> archivesScreen()
                3 -> { println("Программа завершила свою работу")
                    exitProcess(1) }

                else -> println("Введите правильную команду")
            }
        }
        private fun archivesScreen() {  //Экран выбора архивов
            Archives.viewArchivesList()
            println("\nВыберите архив или введите 'Выход' для перехода в предыдущее меню")
            val input = InputAndChecking.isInt(inputString())
            if (input is Int) {
                if (input > Archives.archives.size) {
                    println("=======================")
                    println("Неверный номер архива")
                    println("=======================")
                    archivesScreen()
                } else {
                    menuInArchiveScreen(input)
                }
            } else {
                if (input.toString().lowercase() == "выход") {
                    mainScreen()
                } else {
                    println("=======================")
                    println("Неправильный ввод")
                    println("=======================")
                    archivesScreen()
                }
            }
        }
        private fun listNotesScreen(indexArchive: Int) {
            println("Список заметок архива '${Archives.archives[indexArchive].name}': ")
            for (i in Archives.archives[indexArchive].noteList.indices) {
                println("${i}.${Archives.archives[indexArchive].noteList[i].header}")
            }
            println("\nВыберите заметку или введите 'Выход' для выхода")
            var input = InputAndChecking.isInt(inputString())
            if (input is Int) {
                if (input > Archives.archives[indexArchive].noteList.size) {
                    println("Неверный номер заметки")
                } else {
                    Note.viewNote(Archives.archives[indexArchive].noteList[input], indexArchive)
                }
            } else {
                if(input.toString().lowercase() == "выход") {
                    archivesScreen()
                } else {
                    println("Ошибка ввода")
                    listNotesScreen(indexArchive)
                }
            }
        }
        fun menuInArchiveScreen(indexArchive: Int) {
            println("=======================\nМеню заметок архива: " +
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