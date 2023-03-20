import java.util.Scanner

open class Commander {
    var menu : MutableMap <Int,String> = HashMap ()
    var menuNumb : Int = 0
    var choice : Int = 0
    var noteText : MutableMap <Int,String> = HashMap ()

    fun command() : Int{
        for (j in 1..menu.size) {
            val str = menu[j]
            println("$j. $str")
        }
        return menu.size
    }

    fun commandReader () : Int{
        var comChoice : Int =0
        while (true) {
            val scanner = Scanner(System.`in`)
            if (scanner.hasNextInt()) {
                comChoice =scanner.nextInt()
                return comChoice
            } else println("Введите один из пунктов меню в виде числа")
        }
    }

    open fun printing () {
        while (true) {
            println("Список архивов")
            println("0. Создать архив")
            menuNumb = menu.size+1
            if (menu.size>0) command()
            println("${menuNumb}. Выход.")
            choice = commandReader()
            if (choice == 0) {
                menu.put(menuNumb,addArch())
            }
            if (choice == menuNumb) return
        }
    }

    fun addArch(): String {
        println("Введите имя нового архива:")
        val scanner = Scanner(System.`in`)
        return scanner.next()
    }
    fun addNote(): String {
        println("Введите имя новой заметки:")
        val scanner = Scanner(System.`in`)
        return scanner.next()
    }
    fun writeNote (){
        println("Введите текст заметки")
        val scanner = Scanner(System.`in`)
        noteText.put(menu.size, scanner.next())
        println("Заметка сохранена")
    }
}