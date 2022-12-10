open class Screen {
//    open var menu: MutableList<String> = mutableListOf()
    open val theme: String = ""
    open val title: String = ""

    private val listOfArch: MutableList<String> = mutableListOf()

    fun show(storage: List<String>, theme: String, title: String) {
        var index = 0
//        menu = mutableListOf()
        println("Список $theme")
        println("${index++}. Создать $title")
        storage.map { println("${index++}. $it") }
        println("$index. Выход")
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

        var inp = readln()
        val sizeOfShowNoteMenu = 1
        while (!inputError(inp, sizeOfShowNoteMenu)) { //errors check
            showNote(archive, store, indNote)
            inp = readln()
        }

        when (inp.toInt()) {
            0 -> {
                print("Введите новый текст заметки>> ")
                val newNoteName = readln()
                if (!nameError(listOfArch, newNoteName)) store[archive]?.set(indNote, newNoteName)
                showNote(archive, store, indNote)
//                store[archive]?.set(indNote, newNoteName)
//                showNote(archive, store, indNote)
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
//            if (storage.containsKey(archiveName)) { //check for equals archives
//                println("Ошибка. Имена архивов не должны совпадать!!!")
//                return
//            }
            if (nameError(storage.keys.toMutableList(), archiveName)) return // equals archive name check
            storage[archiveName] = mutableListOf()
        } else if (category == "заметку") {
            print(">>Введите текст заметки: ")
            val noteName = readln()
            if (nameError(listOfArch, noteName)) return // equals note name check
            listOfArch.add(noteName)
            storage.set(titleArchive, listOfArch)
        }
    }
    private fun nameError(list: MutableList<String>, name: String): Boolean {
        return if (list.contains(name)) {
            println("Ошибка. Значения не должны совпадать!!!")
            true
        } else {
            false
        }
    }

    fun inputError(paramMenu: String, storage: Int): Boolean {
        val value = paramMenu.toIntOrNull()
        var errorMessage = ""
        val returnValue = when {
            value == null -> {
//                println("!!Ошибка. Не верное значение. Введите число от 0 до $storage"); false
                errorMessage = "Не верное значение. Введите число от 0 до $storage"
                false
            }
            value < 0 -> {
//                println("!!Ошибка. Значение должно быть больше нуля."); false
                errorMessage = "Значение должно быть больше нуля."
                false
            }
            value > storage-> {
//                println("!!Ошибка. Введите число от 0 до $storage"); false
                errorMessage = "Введите число от 0 до $storage"
                false
            }
            else -> {
                true
            }
        }
        if (errorMessage.isNotEmpty()) println("!!Ошибка. $errorMessage")
        return returnValue
    }

}