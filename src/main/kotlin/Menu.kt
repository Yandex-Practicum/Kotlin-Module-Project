import java.util.Scanner

class Menu(/*private val type: String, private val options: List<Any>*/) {


    fun showMenu(type: String, options: List<Any>) {
        println("\nМеню:")
        println("0. Создать $type")
        println("1. Выход")
        if (!options.isEmpty()) {
            for ((index, option) in options.withIndex()) {
                println("${index + 2}. $option")
            }
        }
    }

    fun choiceMenu(clas: Any, type: String): Triple<Any, String, Boolean> {
        var names = ""
        var flag= true
        while (true) {
            //Вызов меню
            if (type.equals("archives")) showMenu("архив", (clas as ArchivesMenu).archives.keys.toList())
            else
            showMenu("заметку", (clas as NotesArchivesMenu).notes.keys.toList())

            //Получение размера Map, для вывода номера пункта
            var size = if (type.equals("notes")) (clas as NotesArchivesMenu).notes.size
            else (clas as ArchivesMenu).archives.size

            when (val input = getUserChoice(size+1)) {
                0 -> {//Создание
                    if (type.equals("notes")) (clas as NotesArchivesMenu).createNotesArchives()
                    else (clas as ArchivesMenu).createArchive()
                }
                1 -> {//Выход из программы
                    flag= false
                    if (type.equals("notes")) {
                        (clas as NotesArchivesMenu).notes
                        println("Возвращаюсь...")
                    }
                    else {
                        (clas as ArchivesMenu).archives
                        println("Выход....")
                    }
                    break
                }
                in 2..size+2 -> {//Варианты выбора пунктов
                    names = if (type.equals("notes")) (clas as NotesArchivesMenu).notes.keys.elementAt(input-2)
                    else (clas as ArchivesMenu).archives.keys.elementAt(input-2)
                    break
                }
                else -> {
                    println("Такого пункта нет. Попробуйте снова.")
                }
            }
        }
        if (type.equals("notes")) return Triple((clas as NotesArchivesMenu).notes, names, flag)
        else return Triple((clas as ArchivesMenu).archives, names, flag)
    }



    fun getUserChoice(base:Int): Int {
        var input = 0
        var flag = false
        val scanner = Scanner(System.`in`)
        while (!flag) {
            print("Выберите пункт: ")
            val userInput = scanner.nextLine()
            if (userInput.matches(Regex("^([1-9]?[0-9]?)$"))){  //"\\d+"))) {   //^([1-9]?[0-9]?)${
                input = userInput.toInt()
                if (input <= base) {
                    flag = true
                } else {
                    println("Пожалуйста, введите только номер выбранного пункта")
                }
            } else {
                println("Пожалуйста, введите только номер выбранного пункта")
            }
        }
        return input
    }
}


