import java.util.*
import kotlin.system.exitProcess


class Navigation<T> (
//    val source: T
) {
    fun show(source: T) {

        while (true) {

            if (source is StartMenu) {
                source.menu["Создать архив"] = { source.makeArchive() }
                source.menu["Выйти"] = { exitProcess(1) }
                for (i in source.menu.keys.toList()) {
                    println("${source.menu.keys.toList().indexOf(i)}: $i")
                }
                val input = checkInput()
                source.menu.values.toList()[input].invoke()
            } else if (source is Archive) {
                source.menu["Создать заметку"] = { source.newNote() }
                source.menu["Вернуться на предыдущий экран"] = {Navigation<StartMenu>().show(source.source)}
                for (i in source.menu.keys.toList()) {
                    println("${source.menu.keys.toList().indexOf(i)}: $i")
                }
                val input = checkInput()
                source.menu.values.toList()[input].invoke()
            } else if (source is Note) {
                source.menu["Изменить текст заметки"] = { source.changeNote() }
                source.menu["Выйти в меню архивов"] = { Navigation<Archive>().show(source.source) }
                source.menu["Показать заметку"] = { source.showNote() }
                for (i in source.menu.keys.toList()) {
                    println("${source.menu.keys.toList().indexOf(i)}: $i")
                }
                val input = checkInput()
                source.menu.values.toList()[input].invoke()
            }
            /*for (i in source.menu.keys.toList()) {
                println("${source.menu.keys.toList().indexOf(i)}: $i")
            }
            val input = checkInput()
            source.menu.values.toList()[input].invoke()
            */}

        }


        fun checkInput(): Int {
        var output: Int? = null
        while (output == null) {
            println("Введите число, соответствующее выбранному пункту меню")
            val input = Scanner(System.`in`).nextLine().trim()
            output = try {
                input.toInt()
            } catch (e: java.lang.NumberFormatException) {
                null
            }
        }
        return output
    }
}
