import java.util.Scanner

object SelectionScreen {
    private const val TITLE_ARCHIVE = "ВЫБОР АРХИВА:"
    private const val TITLE_NOTE = "ВЫБОР ЗАМЕТКИ:"
    private const val CREATE_AN_ARCHIVE = "Создать архив"
    private const val CREATE_AN_NOTE = "Создать заметку"
    private const val EXIT_MENU = "Выход"
    private const val EXIT = "Программа завершена"
    private const val SELECT_ITEM = "Выберите пункт меню:"
    private const val ENTERING_DIGIT_FIRST = "Необходимо ввести цифру от 0 до "
    private const val ENTERING_DIGIT_LAST = ". Попробуйте снова."
    private const val ITEM_NO = "Такого пункта нет, повторите ввод:"
    private const val FARTHER = "Для продолжения нажмите Enter"

    fun launch(entity: Entity) {
        showMenu(entity)

        when (entity) {
            is ListOfArchives -> {
                val listSize = entity.getListOfArchives().size

                when (val selectedItem = getItemSelection(listSize)) {
                    0 -> CreationScreen.launch(entity)
                    listSize + 1 -> println(EXIT)
                    else -> launch(entity.getListOfArchives()[selectedItem - 1])
                }
            }

            is Archive -> {
                val listSize = entity.getListOfNotes().size
                when (val selectedItem = getItemSelection(listSize)) {
                    0 -> CreationScreen.launch(entity)

                    listSize + 1 -> {
                        println(EXIT)
                        launch(ListOfArchives)
                    }

                    else -> {
                        entity.getListOfNotes()[selectedItem - 1].showNote()
                        println(FARTHER)
                        Scanner(System.`in`).nextLine()
                        launch(ListOfArchives)
                    }
                }
            }
        }
    }

    private fun showMenu(entity: Entity) {
        var itemCounter = 0
        when (entity) {

            is ListOfArchives -> {
                println("\n$TITLE_ARCHIVE")
                println("\t0. $CREATE_AN_ARCHIVE")

                entity.getListOfArchives()
                    .forEachIndexed { index, value ->
                        itemCounter = index + 1; println("\t$itemCounter. ${value.archiveName}")

                    }
            }

            is Archive -> {
                println("\n$TITLE_NOTE")
                println("\t0. $CREATE_AN_NOTE")

                entity.getListOfNotes()
                    .forEachIndexed { index, value ->
                        itemCounter = index + 1; println("\t$itemCounter. ${value.noteName}")

                    }
            }

        }
        println("\t${++itemCounter}. $EXIT_MENU")

    }

    private fun getItemSelection(sizeEntity: Int): Int {

        println(SELECT_ITEM)
        var inputInt: Int
        do {
            try {
                inputInt = Scanner(System.`in`).nextInt()
            } catch (e: Exception) {
                println(ENTERING_DIGIT_FIRST + sizeEntity + 1 + ENTERING_DIGIT_LAST)
                continue
            }
            if (inputInt !in 0..sizeEntity + 1) {
                println(ITEM_NO)
                continue
            }
            return inputInt
        } while (true)
    }

}