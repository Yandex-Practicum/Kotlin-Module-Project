class ArchiveList {
    private val map: MutableMap<String, NoteList> =
        mutableMapOf() // map хранит список архивов, где String - имя архива, NoteList- список заметок
    var activeNoteList: NoteList = NoteList() // В activeNoteList список заметок.

    // Визуальный вывод  Экран 1. Архивы со списком команд
    val menuArchive: () -> Unit = {
        println("-------Список АРХИВОВ-------")
        var menu = "0. - Создать архив\n"

        if (map.isEmpty()) menu += "Архивов нет \n"
        map.keys.forEachIndexed { index, s -> menu += "${index + 1}. - $s \n" }
        menu += "${map.size + 1}. - Выход"
        println(menu)
    }

    // Экран 1. Меню Архивов выбираем пункт
    val choose: (n: Int) -> Unit = { // Проверка корректности ввода в классе Input
            n ->
        when (n) {
            0 -> MENU.nav = MENU.ARCHIVE_CREATE // 0 Создать архив
            // от 1 до размера map выбрать архив и переход на экран 2.Список Заметок
            in 1..map.size -> {
                this.activeNoteList = setActive(n)
                println("Выбран архив №$n - $activeNoteList")
                MENU.nav = MENU.NOTE_LIST
            }

            map.size + 1 -> MENU.nav = MENU.EXIT // выход из программы
            else -> println("Команды или архива с №$n нет в списке")
        }
    }

    // Создать архив
    val createArchive: (name: String) -> Unit = { name ->
        map[name] = NoteList()
        MENU.nav = MENU.ARCHIVE_LIST
    }

    // Выбор активного списка заметок
    private fun setActive(number: Int): NoteList {
        var iterator = 0
        map.forEach { (s, noteList) ->
            iterator++
            if (iterator == number) return noteList
        }
        return NoteList()
    }

    override fun toString(): String {
        var str = ""
        if (map.isEmpty()) return "Пусто" // если архивов нет
        map.keys.forEachIndexed { index, s -> str += "$index. $s \n" } // список архивов
        return str
    }
}