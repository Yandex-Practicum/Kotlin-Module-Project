import kotlin.system.exitProcess

class ArchList : Commander() {
    private var archMenu: MutableMap<Int, Archive> = HashMap()

    private fun addArch() {
        println("Введите имя нового архива:")
        val n = readLine()!!
        val a = Archive(n, NoteList())
        archMenu[(archMenu.size + 1)] = a
        printing()
    }

    override fun command() {
        for (j in 1..archMenu.size) {
            val str = archMenu[j]?.name
            println("$j. $str")
        }
    }

    override fun printing() {
        while (true) {
            println("Список архивов")
            println("0. Создать архив")
            menuNumb = archMenu.size + 1
            if (archMenu.isNotEmpty()) command()
            println("${menuNumb}. Выход.")
            choice = commandReader()
            when (choice) {
                0 -> addArch()
                menuNumb -> exitProcess(1)
                else -> if (archMenu.contains(choice)) archMenu[choice]?.noteMenu?.printing() else println(
                    "Архива с выбранным номером не существует"
                )
            }
        }
    }
}