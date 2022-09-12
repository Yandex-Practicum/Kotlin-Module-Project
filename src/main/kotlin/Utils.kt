import java.util.Scanner

class Utils {
    companion object {
        val input = Scanner(System.`in`)
    }

    fun<T: BaseEntity> showMenu(entities: MutableList<T>, archiveName: String? = null) {
        println("======")
        if (archiveName == null) {
            println("Список архивов:")
            println("0. Создать архив")
        } else {
            println("Список заметок архива $archiveName:")
            println("0. Создать заметку")
        }

        val lastIndex = entities.size

        if(lastIndex != 0) {
            entities.forEachIndexed { index, entity -> println("${index + 1}. ${entity.name}") }
        }

        println("${lastIndex + 1}. Выход")
        print("Введите пункт меню: ")
    }

    fun readNumber(max: Int): Int {
        while (true) {
            val input = validateInput(input.nextLine())
            if (input == -1) {
                print("Неверный ввод, введите целое число от 0 до ${max + 1}: ")
                continue
            }
            if (input > max + 1) {
                print("Число должно быть от 0 до ${max + 1}. Повторите ввод: ")
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