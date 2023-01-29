import java.util.*
import kotlin.system.exitProcess


class Navigation() {
    fun <T: Menu> show(source: T) {

        while (true) {

            if (source is StartMenu) {
                source.menu["Создать архив"] = { source.makeArchive() }
                source.menu["Выйти"] = { exitProcess(1) }
            } else if (source is Archive) {
                source.menu["Создать заметку"] = { source.newNote() }
                source.menu["Вернуться к выбору архива"] = {Navigation().show(source.source)}
            } else if (source is Note) {
                source.menu["Изменить текст заметки"] = { source.changeNote() }
                source.menu["Вернуться к выбору заметки"] = { Navigation().show(source.source) }
                source.menu["Показать заметку"] = { source.showNote() }
            }
            makeMenu(source)
            }

        }

        fun <T: Menu> makeMenu(source: T){
            for (i in source.menu.keys.toList()) {
                println("${source.menu.keys.toList().indexOf(i)}: $i")
            }
            val input = checkInput()
            try {
                source.menu.values.toList()[input].invoke()
            } catch (e: java.lang.IndexOutOfBoundsException) {
                println("Вы ввели слишком большое число. Введите число, соответствующее выбранному пункту меню")
            }
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
