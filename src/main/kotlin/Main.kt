enum class ListMenu {
    ARCHIVES,
    CREATE_ARCHIVES,
    NOTES,
    CREATE_NOTES,
    CURRENT_NOTE
}

fun main() {

    println("ПРОГРАММА МОИ ЗАМЕТКИ")

    val currentChoice = CurrentChoice(true)
    var currentMenu: MutableMap<Int, MenuItem>
    val callMenu: Map<ListMenu, Menu> = mapOf(
        ListMenu.ARCHIVES           to MenuArchives(),
        ListMenu.CREATE_ARCHIVES    to MenuCreateArchive(),
        ListMenu.NOTES              to MenuNotes(),
        ListMenu.CREATE_NOTES       to MenuCreateNote(),
        ListMenu.CURRENT_NOTE       to MenuCurrentNote()
    )

    var userAnswer: Int?
    val userInput = UserInput()

    do {
        //создаем меню
        currentMenu = callMenu[currentChoice.currentListMenu]!!.createMenu(currentChoice)

        // показываем меню
        showMenu(currentMenu)

        // получаем ответ
        userAnswer = userInput.getUserAnswerMenu()

        // вызываем лямбду
        if (userAnswer !== null) {
            if (userAnswer !in (0..currentMenu.keys.last())) println("Меню с таким номером не существует, повторите ввод")
            else currentMenu[userAnswer]?.doAction?.invoke()
        } else println("Ошибка ввода номер меню, повторите ввод")

    } while (currentChoice.noEndProgram)
}

fun showMenu (menuForShow: MutableMap<Int, MenuItem>) {
    menuForShow.forEach{ if (it.key == -1) println(it.value.name) else println("${it.key} ${it.value.name}") }
}

