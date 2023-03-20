import java.util.Scanner


fun main() {
    val archScreen :ArchList = ArchList()
    archScreen.printing()
}

class ArchList () : Commander() {
    override fun printing () {
        val noteMenu : NoteList = NoteList()
        while (true) {
            println("Список архивов")
            println("0. Создать архив")
            menuNumb = menu.size+1
            if (menu.size>0) command()
            println("${menuNumb}. Выход.")
            choice = commandReader()
            when(choice) {
                0 -> {
                    menu.put(menuNumb, addArch())

                }
                menuNumb -> return
                else ->  if (menu.contains(choice)) noteMenu.printing() else println("Архива с выбранным номером не существует")
            }
        }
    }
}

class NoteList () : Commander () {
    override fun printing () {
        val noteMenu : NoteList = NoteList()
        while (true) {
            println("Список заметок")
            println("0. Создать заметку")
            menuNumb = menu.size+1
            if (menu.size>0) command()
            println("${menuNumb}. Выход в меню архивов.")
            choice = commandReader()
            when(choice) {
                0 -> {
                    menu.put(menuNumb, addNote())
                    println("Новая заметка создана!")
                    writeNote ()
                }
                menuNumb -> return
                else ->  if (menu.contains(choice)) {
                    println("Текст заметки:")
                    println(noteText[choice])

                }
                else println("Заметки с выбранным номером не существует")
            }
        }
    }
}
