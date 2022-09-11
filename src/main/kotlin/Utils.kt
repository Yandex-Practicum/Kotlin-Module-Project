import java.util.Scanner

class Utils {
    companion object {
        val input = Scanner(System.`in`)
    }

    fun<T: BaseEntity> showMenu(entities: MutableList<T>) {
        if (entities.first() is ArchiveEntity) {
            println("Список архивов:")
            println("0. Создать архив:")
        }
        if (entities.first() is NoteEntity) {
            println("Список заметок:")
            println("0. Создать заметку:")
        }
        entities.forEachIndexed { index, entity -> println("${index + 1}. ${entity.name}") }
        val lastIndex = entities.size
        println("${lastIndex + 1}. Выход")
        println("Введите пункт меню: ")
    }

    fun readNumber(max: Int): Int {
        while (true) {
            val input = validateInput(input.nextLine())
            if (input == -1) {
                println("Неверный ввод, введите целое число: ")
                continue
            }
            if (input > max) {
                println("Число должно быть от 0 до $max. Повторите ввод: ")
                continue
            }
            return input
        }
    }

    fun readString(): String {
        while (true) {
            val input = input.nextLine()
            if (input == "") {
                println("Ввод не должен быть пустым, повторите ввод: ")
                continue
            }
            return input
        }
    }

    private fun validateInput(input: String): Int {
        return input.toIntOrNull() ?: return -1
    }
}