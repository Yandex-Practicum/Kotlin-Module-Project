package menu

import java.util.Scanner

abstract class BaseMenu<T>(private val data: List<T>) {
    private val scanner = Scanner(System.`in`)

    fun show() {
        while (true) {
            println(CHOOSE_OPTION)
            println(chooseCreate())
            chooseOpen(data)
            printGoBack()
            when (val action = getAction()) {
                0 -> add(scanner)
                in 1..data.size -> choose(action!!)
                data.size+1 -> goBack()
                else -> checkInput(action)
            }
        }
    }

    private fun choose(index: Int) {
        open(data[index-1])
    }

    private fun checkInput(input: Int?) {
        if (input == null) {
            println(INVALID_INPUT)
            return
        }
        if (input.toInt() > data.size+1)
            println(WRONG_CHOICE)
    }

    private fun chooseOpen(data: List<T>) {
        if (data.isNotEmpty()) {
            data.forEachIndexed { index, element -> println("${index+1}. Открыть $element")}
        }
    }

    open fun printGoBack() {
        println("${data.size+1}. "+GO_BACK)
    }

    private fun getAction() = scanner.nextLine().toIntOrNull()

    abstract fun chooseCreate(): String
    abstract fun add(scanner: Scanner)
    abstract fun open(elem: T)
    abstract fun goBack()

    companion object {
        const val CHOOSE_OPTION = "Введите цифру чтобы выбрать необходимое действие:"
        const val WRONG_CHOICE = "Такого действия нет!"
        const val INVALID_INPUT = "Необходимо ввести число!"
        const val GO_BACK = "Вернуться назад"
    }
}


