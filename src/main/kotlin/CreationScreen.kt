import java.util.Scanner

object CreationScreen {
    private const val CREATING_ARCHIVE = "СОЗДАНИЕ АРХИВА:"
    private const val CREATING_NOTE = "СОЗДАНИЕ ЗАМЕТКИ:"
    private const val ENTERING_ARCHIVE_NAME = "Введите название архива:"
    private const val ENTERING_NOTE_NAME = "Введите название заметки:"
    private const val OBJECT_CREATED_FIRST = "Объект \""
    private const val OBJECT_CREATED_LAST = "\" успешно создан"
    private const val WRONG_NAME =
        "Название объекта не может быть пустым и не может повторяться. Введите имя:"
    private const val ENTERING_TEXT = "Введите текст заметки, Для продолжения работы нажмите Enter:"
    private const val EMPTY_NOTE = "Заметка не должна быть пустой. Создайте заметку снова:"

    private val scanner = Scanner(System.`in`)

    fun launch(entity: Entity) {
        when (entity) {
            is ListOfArchives -> {
                println(CREATING_ARCHIVE)
                println('\t' + ENTERING_ARCHIVE_NAME)
                val newArchive = Archive(getObjectName(entity))
                entity.addArchive(newArchive)
                println(OBJECT_CREATED_FIRST + newArchive.archiveName + OBJECT_CREATED_LAST)
                SelectionScreen.launch(entity)
            }

            is Archive -> {
                println(CREATING_NOTE)
                println('\t' + ENTERING_NOTE_NAME)
                val inputName = getObjectName(entity)
                println('\t' + ENTERING_TEXT)
                val inputText = scanner.nextLine()
                if (inputText.isEmpty()) {
                    println(EMPTY_NOTE)
                    launch(entity)
                }

                entity.addNote(inputName, inputText)

                println(OBJECT_CREATED_FIRST + entity.getNote(inputName)!!.noteName + OBJECT_CREATED_LAST)
                SelectionScreen.launch(ListOfArchives)
            }
        }
    }


    private fun getObjectName(entity: Entity): String {

        var name: String
        when (entity) {
            is ListOfArchives -> {
                do {
                    name = scanner.nextLine()
                    if (name.isEmpty() || entity.getListOfArchives()
                            .find { it.archiveName == name } != null
                    ) {
                        println(WRONG_NAME)
                        continue
                    }
                    return name
                } while (true)
            }

            is Archive -> {
                do {
                    name = scanner.nextLine()
                    if (name.isEmpty() || entity.getListOfNotes()
                            .find { it.noteName == name } != null
                    ) {
                        println(WRONG_NAME)
                        continue
                    }
                    return name
                } while (true)
            }
        }
    }

}