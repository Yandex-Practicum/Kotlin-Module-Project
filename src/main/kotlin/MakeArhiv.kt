import java.util.Scanner

class Menu {
    val scanner = Scanner(System.`in`)
    fun showMenuArhive(): Int {

        println("Меню архивов:")
        println("0. Создать архив")
        println("1. Уже созданный архив")
        println("2. Выход из программы")
        println("Выберите пункт меню")

        return Menu().cycle()

    }

    fun notesMenu(): Int {
        println("Меню заметок:")
        println("0. Создать заметку")
        println("1. Уже созданная заметка")
        println("2. Выход в меню Архивов")
        println("Выберите пункт меню")
        return Menu().cycle()

    }

    fun showError() {
        println("Выберете пункт меню")
    }

    fun cycle(): Int {

        while (true) {

            if (scanner.hasNextInt()) {
                val scan = scanner.nextInt()
                if (scan in 0..2) {
                    return scan
                } else {
                    Menu().showError()
                    scanner.nextLine()
                }
            } else {
                Menu().showError()
                scanner.nextLine()
            }
        }
    }
}