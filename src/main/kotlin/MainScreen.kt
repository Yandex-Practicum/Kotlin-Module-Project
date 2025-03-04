class MainScreen() {
    private var screenType = ARCHIVE
    private val data = mutableMapOf<Archive, ArrayList<Note>>()
    var isExit = false

    private lateinit var active: Archive //ссылка на архив для экрана с записями

    fun showMenu(screenType: List<String> = this.screenType) {
        val caption = "_______ Меню ${screenType[2].lowercase()} _______"
        val firstItem = "Создать ${screenType[1].lowercase()}"
        val lastItem = "Выйти"
        var input = 0
        var num = 0
        val dataItems = if (screenType == ARCHIVE) data.keys.toList() else active.notes.toList()

        println(caption)
        println("$num. $firstItem")
        for (item in dataItems) {
            println("${++num}. \"${item.name}\"")
        }
        println("${++num}. ${lastItem}")
        println("---------------")

        input = Input.intInput(num)
        select(dataItems, input, num)
    }

    private fun select(dataItems: List<Selectable>, input: Int, menuSize: Int) {
        if (menuSize > 1) {
            when (input) {
                0 -> create()
                in 1 until menuSize -> {
                    if (screenType == ARCHIVE) {
                        active = dataItems[input - 1] as Archive
                        screenType = NOTE
                    } else {
                        showNote(dataItems[input - 1] as Note)
                    }
                }

                menuSize -> {
                    if (screenType == NOTE) {
                        screenType = ARCHIVE
                    } else {
                        isExit = true
                    }
                }
            }
        } else {
            when (input) {
                0 -> create()
                1 -> {
                    if (screenType == NOTE) {
                        screenType = ARCHIVE
                    } else {
                        isExit = true
                    }
                }
            }
        }
    }

    private fun create() {
        println("Процедура создания ${screenType[2].lowercase()}")

        val name = Input.textInput(
            "Введите название ${screenType[2].lowercase()}}:\n(не более $NAME_MAX_LENGTH символов)",
            NAME_MAX_LENGTH
        )

        when (screenType) {
            ARCHIVE -> {
                val archive = Archive(name)
                data.put(archive, archive.notes)
            }

            NOTE -> {
                val text = Input.textInput(
                    "Введите текст ${NOTE[2].lowercase()}:\n(не более $TEXT_MAX_LENGTH символа)",
                    TEXT_MAX_LENGTH
                )
                val note = Note(name, text)
                active.notes.add(note)
            }
        }
    }

    private fun showNote(note: Note) {
        println("====== Просмотр записи ${note.name} ======")
        println("Содержимое записи:")
        println("${note.text}")
        println("====== Конец ======")
        println("\nВведите любой символ, чтобы вернуться в меню...")
        Input.scanner.nextLine()
    }

    companion object {
        const val NAME_MAX_LENGTH = 32
        const val TEXT_MAX_LENGTH = 1024
        val ARCHIVE = listOf("Архив", "Архива", "Архивов")
        val NOTE = listOf("Запись", "Записи", "Записей")
    }
}