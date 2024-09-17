import java.util.Scanner

class Library(name:String, archiveList: MutableMap<Int, Archive>) {
    val navigationTag: String = "Архивы"
    val name:String = ""
    val archive = mutableMapOf<String, Archive>()

    fun greet() {
        println("Добро пожаловать в Заметки! /n Введите команду: /n0 - Выход /n1 - Перейти к списку архивов /n2 - Создать новый архив")
        while (true){
            val input = Scanner(System.`in`).nextLine()
            when(input){

            }
        }
    }

    fun showContent() {
        for (line in archive){
            
        }
    }
}