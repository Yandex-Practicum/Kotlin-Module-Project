package menu

import datastructure.Container

internal const val LINE = "/////////////////////"

/*
Абстрактный класс конструктора меню
Для переиспользования общего кода рекомендуем использовать отдельный класс, который содержит код:
По выводу пунктов меню;
По чтению пользовательского ввода;
По выполнению определённых операций на выбор пункта меню.
*/

abstract class AbstСonstructorMenu {

    abstract val container: Container?
    abstract var menu: String
    abstract val commands: MutableList<String>

    abstract fun validateCommand()

    internal fun menuСonstructor() {
        println(menu)
        commands.forEachIndexed { index, option ->
            println("$index. $option")
        }

    }
}