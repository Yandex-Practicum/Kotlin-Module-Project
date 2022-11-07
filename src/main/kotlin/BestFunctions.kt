import java.util.*

class BestFunctions {

    private val input = Scanner(System.`in`)

    fun push(menu: MutableList<MenuFields>, menuStr: String, str: String, forClose: String) : Boolean{
        println(showMenu(menu, menuStr, str))
        val inputString = input.nextLine().toString()
        if (checkInput(menu, inputString)) {
            val inputInt = inputString.toInt()
            if (!chooseNumber(
                    menu,
                    inputInt,
                    forClose
                )
            ) {
                return true
            }
        }
        return false
    }

    private fun chooseNumber(
        menu: MutableList<MenuFields>,
        inputInt: Int,
        forClose: String
    ): Boolean {
        for (m in menu) {
            return when (inputInt) {
                0 -> {
                    println(forClose)
                    false
                }
                1 -> {
                    createObj(menu, m)
                    true
                }
                else -> {
                    menu[inputInt].start()
                    true
                }
            }
        }
        return true
    }

    private fun createObj(menuObj: MutableList<MenuFields>, menuFields: MenuFields) {
        when (menuFields) {
            is Archive -> {
                println("Создание архива\nВведите имя архива")
                val nameObj = input.nextLine().toString()
                if (nameObj.isNotEmpty()) {
                    menuObj.add(Archive(menuObj.size, nameObj))
                    println("Архив $nameObj можно найти под номером ${menuObj.size - 1}\n")
                } else {
                    println("Вы не ввели имя Архива. Возвращаем вас в главное меню")
                }

            }
            is Note -> {
                println("Создание заметки\nВведите имя заметки")
                val nameObj = input.nextLine().toString()
                println("Введите текст заметки")
                val noteText = input.nextLine().toString()
                if (nameObj.isNotEmpty()) {
                    menuObj.add(Note(menuObj.size, nameObj, noteText))
                    println("Заметку $nameObj можно найти под номером ${menuObj.size - 1}\n")
                } else {
                    println("Вы не ввели имя Заметки. Возвращаем вас в главное меню")
                }

            }
            else -> println("где-то закралась ошибка")
        }
    }

    fun showMenu(menu: MutableList<MenuFields>, menuStr: String, str: String): String {
        var p = "$menuStr. Что хотите сделать?\n"
        for (a in menu) {
            p += if (a.id <= 1) {
                "${a.id} - ${a.name}\n"
            } else {
                "${a.id} - Открыть $str \"${a.name}\"\n"
            }
        }
        return p
    }

    fun checkInput(menu: MutableList<MenuFields>, input: String): Boolean {
        for (char in input) {
            if (char.isDigit()) {
                continue
            } else {
                println("Некорректный ввод. Необходимо вводить цифры")
                return false
            }
        }
        if (input.isEmpty()){
            println("Вы ничего не ввели")
            return false
        }
        return if (input.toInt() < menu.size) {
            true
        } else {
            println("Такого числа нет. Введите корректное число пункта меню")
            false
        }
    }
}