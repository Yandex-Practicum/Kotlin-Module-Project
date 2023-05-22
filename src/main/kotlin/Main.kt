fun main() {
   // var menuArchive: mut
    println("МОИ ЗАМЕТКИ")
    val currentChoice = CurrentChoice(true)
    var currentMenu: MutableMap<Int, MenuItem> = mutableMapOf()
    val menuArchives = MenuArchives()
    val menuCreteArchive = MenuCreateArchive()
    val menuNotes = MenuNotes()
    val menuCreateNote = MenuCreateNote()
    val menuCurrentNote = MenuCurrentNote()
    var userAnswer: Int?
    val userInput = UserInput()

    do {
        //создаем меню
        when (currentChoice.numberListMenu) {
            0 -> currentMenu = menuArchives.createMenu(currentChoice)
            1 -> currentMenu = menuCreteArchive.createMenu(currentChoice)
            2 -> currentMenu = menuNotes.createMenu(currentChoice)
            3 -> currentMenu = menuCreateNote.createMenu(currentChoice)
            4 -> currentMenu = menuCurrentNote.createMenu(currentChoice)
        }
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

