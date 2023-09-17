class MenuGenerator {
    private var whenNoElements: String = ""
    private var whenElementsListed: String = ""
    private var exitCommand: String = ""

    fun <T> generateMenu(menuType: String, list: MutableList<T>) {

        when (menuType) {
            ARCHIVES -> {
                whenNoElements = NO_ARCHIVES
                whenElementsListed = LIST_OF_ARCHIVES
                exitCommand = EXIT_PROG
            }

            NOTES -> {
                whenNoElements = NO_NOTES
                whenElementsListed = LIST_OF_NOTES
                exitCommand = EXIT_TO_ARCHIVES
            }
        }


        if (list.isEmpty()) {
            println("$whenNoElements\n1. $exitCommand")

        } else {
            println(whenElementsListed)
            list.forEachIndexed() { index, element -> println("${index + 1}. $element") }
            println("${list.size + 1}. $exitCommand")
        }


    }

    companion object {
        private const val ARCHIVES = "Archives"
        private const val NOTES = "Notes"
        private const val NO_ARCHIVES =
            "\nМЕНЮ 'АРХИВЫ'\nВы пока не создали ни одного архива. Введите номер команды.\n0. Создать архив"
        private const val LIST_OF_ARCHIVES =
            "\nМЕНЮ 'АРХИВЫ'\nДля просмотра архива введите его номер, либо введите номер команды:\n0. Создать архив"
        private const val NO_NOTES = "\nМЕНЮ 'ЗАМЕТКИ'\nСписок заметок пуст. Введите номер команды.\n0. Создать заметку"
        private const val LIST_OF_NOTES =
            "\nМЕНЮ 'ЗАМЕТКИ'\nДля просмотра заметки введите её номер, либо введите номер команды:\n0. Создать заметку"
        private const val EXIT_PROG = "Выход из приложения"
        private const val EXIT_TO_ARCHIVES = "Выход в меню 'АРХИВЫ'"


    }
}


