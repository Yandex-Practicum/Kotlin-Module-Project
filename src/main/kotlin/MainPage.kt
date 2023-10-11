import java.util.Scanner

class MainPage(name: String): Page(name) {
    private val list: MutableList<Archive> = mutableListOf()

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
            var stop = false
            navigate(
                onCreate = {this.createArchive() },
                onClick = {value -> this.list[value].show()},
                onExit = {stop = true}
            )
            if (stop) break
        }
    }

    private fun createArchive() {
        println("Введите название нового архива:")
        val name = Scanner(System.`in`).nextLine()
        list.add(Archive(name))
    }

}