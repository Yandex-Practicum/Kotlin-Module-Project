open class Screen {
    open var menu: MutableList<String> = mutableListOf()
    open val theme: String = ""
    open val title: String = ""


    private val listOfArch: MutableList<String> = mutableListOf()

    fun show(storage: List<String>, theme: String, title: String) {
        menu = mutableListOf()
        println("Список $theme")
        menu.add("Создать $title")
        storage.map { menu.add(it) }
        menu.add("Выход")
        menu.forEachIndexed { i, v -> println("$i. $v") }
        print(">>Введите значение: ")
    }

    fun showArchNotes(archStorage: String, store: LinkedHashMap<String, MutableList<String>>) {
        println("Архив $archStorage")
        Note().run(store, archStorage)
    }

    fun showNote(archive: String, store: LinkedHashMap<String, MutableList<String>>, indNote: Int) {
        println("Просмотр заметки")
        println("# ${store[archive]?.get(indNote)}")
        println("0. Изменить заметку")
        println("1. Выход")
        print(">>Введите значение: ")
//        в отдельный блоу
        var inp = readln()
        while (!inputError(inp, listOf("", ""))) { //errors check
            showNote(archive, store, indNote)
            inp = readln()
        }
//        конец блока
        when (inp.toInt()) {
            0 -> {
                print("Введите новый текст заметки>> ")
                store[archive]?.set(indNote, readln())
                showNote(archive, store, indNote)
            }
            1 -> Note().run(store, archive)
        }
    }

    fun showCreate(
        category: String,
        storage: LinkedHashMap<String, MutableList<String>>,
        titleArchive: String = ""
    ) {
        println("Создать $category")
        if (category == "архив") {
            print(">>Введите название архива: ")
            val archiveName = readln()
            if (storage.containsKey(archiveName)) { //check for equals archives
                println("Ошибка. Имена архивов не должны совпадать!!!")
                return
            }
            storage[archiveName] = mutableListOf()
        } else if (category == "заметку") {
            print(">>Введите текст заметки: ")
            listOfArch.add(readln())
            storage.set(titleArchive, listOfArch)
        }
    }

    fun inputError(paramMenu: String, storage: List<String>): Boolean {
        val value = paramMenu?.toIntOrNull()
        return when {
            value == null -> {
                println("!!Ошибка. Не верное значение. Введите число от 0 до ${storage.size - 1}\""); false
            }
            value < 0 -> {
                println("!!Ошибка. Значение должно быть больше нуля."); false
            }
            value > storage.size - 1 -> {
                println("!!Ошибка. Введите число от 0 до ${storage.size - 1}"); false
            }
            else -> {
                true
            }
        }
    }
}