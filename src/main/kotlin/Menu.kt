import java.util.Scanner

class Menu(val list: MutableList<Archive>) {

    private var menuStatus = MenuStatus.ARCHIVE
    var selectedArchiveIndex = -1
    var selectedNoteIndex = -1
    private fun printMenu(list: MutableList<out File>, menuStatus: MenuStatus) {

        if (menuStatus == MenuStatus.ARCHIVE) println("Список архивов\n0.Создать архив") else println(
            "Список заметок\n0.Создать Заметку"
        )

        for (item in list) {
            println("${list.indexOf(item) + 1}. ${item.name}  ")
        }

        println("${list.size + 1}.выход")
    }


    fun runMenu() {


        while (true) {
            when (menuStatus) {
                MenuStatus.ARCHIVE -> printMenu(list, MenuStatus.ARCHIVE)

                MenuStatus.NOTES -> {
                    printMenu(list[selectedArchiveIndex].notes, MenuStatus.NOTES)
                }

                MenuStatus.CREATE -> {
                    createObject(selectedArchiveIndex)
                    continue
                }

                MenuStatus.VIEW -> {
                    viewNote(selectedArchiveIndex, selectedNoteIndex)
                    continue
                }

            }

            val selectedIndex = readIntInput(menu = Menu(list), menuStatus, selectedArchiveIndex)
            when {
                selectedIndex == list.size + 1 -> if (menuStatus == MenuStatus.ARCHIVE) return else chooseMenuPoint(
                    selectedIndex
                )

                selectedIndex == 0 -> menuStatus = MenuStatus.CREATE
                selectedIndex > 0 -> chooseMenuPoint(selectedIndex)
            }
        }
    }


    private fun readIntInput(menu: Menu, menuStatus: MenuStatus, selectedArchiveIndex: Int): Int {
        var input = Scanner(System.`in`).nextLine()
        val menuExitPoint: Int = when (menuStatus) {
            MenuStatus.ARCHIVE -> menu.list.size + 1
            MenuStatus.NOTES -> menu.list[selectedArchiveIndex].notes.size + 1
            else -> 0
        }
        val listMenu: List<String> = (0..menuExitPoint).toList().map { it.toString() }
        while (!listMenu.contains(input)) {
            println("введите число, соответствующее пункту меню")
            input = Scanner(System.`in`).nextLine()
        }
        return input.toInt()
    }


    private fun createObject(selectedArchiveIndex: Int): Unit = when {
        selectedArchiveIndex < 0 -> {
            println("Введите название архива")
            val name = readLineInput()
            list.add(Archive(name, mutableListOf()))
            menuStatus = MenuStatus.ARCHIVE
        }

        selectedArchiveIndex >= 0 -> {
            println("Введите название заметки")
            val name = readLineInput()
            println("Введите текст заметки")
            val body = readLineInput()
            list[selectedArchiveIndex].notes.add(Note(name, body))
            menuStatus = MenuStatus.NOTES
        }

        else -> {}
    }

    private fun viewNote(selectedArchiveIndex: Int, selectedNoteIndex: Int) {
        if (selectedNoteIndex >= 0) {
            println("Содержание заметки ${list[selectedArchiveIndex].notes[selectedNoteIndex].name}:\n")
            println("${list[selectedArchiveIndex].notes[selectedNoteIndex].text}\n")
        }

        println("нажмите ENTER для выхода в предыдущее меню")
        menuStatus = MenuStatus.NOTES
        Scanner(System.`in`).nextLine()
    }

    private fun readLineInput(): String {
        var input = Scanner(System.`in`).nextLine()
        while (input == "") {
            println("Ввод не должен быть пустым. Введите текст")
            input = Scanner(System.`in`).nextLine()
        }
        return input
    }

    private fun chooseMenuPoint(selectedIndex: Int) {

        when (menuStatus) {
            MenuStatus.ARCHIVE -> {
                selectedArchiveIndex = selectedIndex - 1
                selectedNoteIndex = selectedIndex - 1
                menuStatus = MenuStatus.NOTES
            }

            MenuStatus.NOTES -> {
                if (selectedIndex == list[selectedArchiveIndex].notes.size + 1) {
                    menuStatus = MenuStatus.ARCHIVE
                    selectedArchiveIndex = -1

                } else {
                    selectedNoteIndex = selectedIndex - 1
                    menuStatus = MenuStatus.VIEW
                }
            }

            else -> return
        }

    }
}


