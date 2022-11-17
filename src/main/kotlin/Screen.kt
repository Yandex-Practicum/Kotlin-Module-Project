import MenuNavigator.NUMBER_OF_SYSTEM_ENTRIES

sealed class Screen {
    open fun printNavigation() {}
    open fun printEntries(list: MutableList<out Any>) {}

    object AllArchives : Screen() {
        override fun printNavigation() {
            println("Вы находитесь в меню создания нового или выбора имеющегося архива. " +
                    "Введите '0' для выхода из программы, '1' для создания новго архива " +
                    "или номер архива для чтения/добавления заметок." +
                    "\n0. Выход из программы\n1. Создание нового архив")
        }

        override fun printEntries(list: MutableList<out Any>) {
            for (item in list) {
                println("${list.indexOf(item) + NUMBER_OF_SYSTEM_ENTRIES}. $item")
            }
        }
    }

    class ChosenArchive(var archive: Archive): Screen() {
        override fun printNavigation() {
            println("Вы находитесь в меню выбора создания или изменения заметок в архиве $archive. " +
                    "Введите '0' для возврата в меню выбора архива, '1' для создания новой заметки " +
                    "или номер заметки, которую вы хотите прочитать или изменить." +
                    "\n0. Возврат в меню выбора архива\n1. Создание новой заметки")
        }

        override fun printEntries(list: MutableList<out Any>) {
            for (item in list) {
                println("${list.indexOf(item) + NUMBER_OF_SYSTEM_ENTRIES}. $item")
            }
        }
    }

    class ChosenNote(var note: Note): Screen()

}

