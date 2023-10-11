import java.util.Scanner

class Menu(val list: MutableList<Archive>) {

    fun printMenu(list: MutableList<out File>, fileType: String) {

        if (fileType == "Архив") println("Список архивов\n0.Создать архив") else println("Список заметок\n0.Создать Заметку")

        for (item in list) {
            println("${list.indexOf(item) + 1}. ${item.name}  ")
        }

        println("${list.size + 1}.выход")
    }


    fun runMenu() {
        var menuStatus = MenuStatus.ARCHIVE
        var selectedArchiveIndex = -1
        var selectedNoteIndex = -1
        while (true) {
            when (menuStatus) {
                MenuStatus.ARCHIVE -> {
                    printMenu(this.list, "Архив")

                }

                MenuStatus.NOTES -> {

                    printMenu(this.list[selectedArchiveIndex].notes, "Заметки")

                }

                MenuStatus.CREATE -> {
                    when {
                        selectedArchiveIndex < 0 -> {
                            println("Введите название архива")
                            val name = readLineInput()
                            list.add(Archive(name, mutableListOf()))
                            //printMenu(list, "Архив")
                            menuStatus = MenuStatus.ARCHIVE
                            continue
                        }

                        selectedArchiveIndex >= 0 -> {
                            println("Введите название заметки")
                            val name = readLineInput()
                            println("Введите текст заметки")
                            val body = readLineInput()
                            list[selectedArchiveIndex].notes.add(Note(name, body))
                            menuStatus = MenuStatus.NOTES
                            continue
                        }
                    }
                }

                MenuStatus.VIEW -> {

                    if (selectedNoteIndex >= 0) {
                        println("Содержание заметки ${list[selectedArchiveIndex].notes[selectedNoteIndex].name}:\n")
                        println(list[selectedArchiveIndex].notes[selectedNoteIndex].text)
                    }

                    println("нажмите ENTER для выхода в предыдущее меню")
                    menuStatus = MenuStatus.NOTES
                    Scanner(System.`in`).nextLine()
                    continue
                }

            }

            val selectedIndex = readIntInput(menu = Menu(list))
            when {
                selectedIndex == 0 ->menuStatus = MenuStatus.CREATE

                selectedIndex > 0 -> {

                    when (menuStatus) {
                        MenuStatus.ARCHIVE -> {
                            if (selectedIndex == this.list.size + 1) return
                            selectedArchiveIndex = selectedIndex - 1
                            selectedNoteIndex = selectedIndex - 1
                            menuStatus = MenuStatus.NOTES

                        }

                        MenuStatus.NOTES -> {
                            if (selectedIndex == this.list[selectedArchiveIndex].notes.size + 1) {
                                menuStatus = MenuStatus.ARCHIVE
                            } else {
                                selectedNoteIndex = selectedIndex - 1
                                menuStatus = MenuStatus.VIEW
                            }
                        }

                        else -> return
                    }
                }

                else -> return


            }
        }
    }


}


private fun readIntInput(menu: Menu): Int {
    var input = Scanner(System.`in`).nextLine()
    while (input.toIntOrNull() == null) {
        println("введите число")
        input = Scanner(System.`in`).nextLine()
    }
    if (input.toIntOrNull() != null) {

        if (input.toInt() > menu.list.size + 1) {
            println("введите число от 0 до ${menu.list.size + 1}, соответствующее пункту меню")
            input = Scanner(System.`in`).nextLine()
        }
    }

    return input.toInt()
}

private fun readLineInput(): String {
    var input = Scanner(System.`in`).nextLine()
    while (input == "") {
        println("Ввод не должен быть пустым. Введите текст")
        input = Scanner(System.`in`).nextLine()
    }
    return input
}

