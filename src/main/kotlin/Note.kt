class Note(val name: String, private var text: String) {
    constructor(name: String) : this(name, "")

    // Отображение земетки и меню с командами
    val showMainMenu: () -> Unit = {
        var str = ("-------ЗАМЕТКА $name-------\n")
        str += this.text
        str += "-----------------------------\n"
        str += "0. - Добавить текст\n"
        str += "1. - Назад"
        println(str)
    }

    // Навигация по экрану заметки
    val choose: (n: Int) -> Unit = { n ->
        when (n) {
            0 -> MENU.nav = MENU.NOTE_EDIT
            1 -> MENU.nav = MENU.NOTE_LIST
            else -> println("Пункта меню $n нет в списке")
        }
    }

    //  добавление текста заметки
    val addText: (text: String) -> Unit = { text ->
        this.text += "$text\n"
        MENU.nav = MENU.NOTE_SHOW
    }
}