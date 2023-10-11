import java.util.Scanner

class MainPage {
    private var list: MutableList<Archive> = mutableListOf()

    fun show() {

        while (true) {
            println(
                "Ввeдите пункт меню для действия \n" +
                        "\"q\" - выход из программы \n" +
                        "0. Создать новый архив"
            )
            for (i in list) {
                println("${list.indexOf(i) + 1}. ${i.name}")
            }
            val input = Scanner(System.`in`).nextLine()
            if (input == "q") break
            else if (input == "0") this.createArchive()
            else this.list[input.toInt() - 1].show()
        }
    }

    private fun createArchive() {
        println("Введите название нового архива:")
        val name = Scanner(System.`in`).nextLine()
        list.add(Archive(name))
    }

}