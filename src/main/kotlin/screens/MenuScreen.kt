package screens

import objects.PunktMenu
import java.util.Scanner

open class MenuScreen {
    private val scanner = Scanner(System.`in`)

    fun showMenuScreen(title: String, punkts: List<PunktMenu>){
        while (true){
            println(title)
            punkts.forEachIndexed { index, item -> println("$index. ${item.punkt}") }

            println("Введите пункт меню")
            val input = scanner.nextLine()

            val option = input.toIntOrNull()
            if(option == null) {
                println("Введите пункт меню")
                continue
            }
            if( option !in punkts.indices){
                println("Нет такого пункта.")
                continue
            }
            return punkts[option].action()
        }
    }
}