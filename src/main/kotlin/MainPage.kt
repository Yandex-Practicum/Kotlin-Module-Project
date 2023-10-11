import java.util.Scanner

class MainPage(name: String) : Page(name) {
    private val list: MutableList<Archive> = mutableListOf()

    fun show() {
        val message = "Ввeдите пункт меню для действия \n" +
                "\"q\" - выход из программы \n" +
                "0. Создать новый архив"

        navigate(
            message,
            list,
            onCreate = { this.createArchive() },
            onClick = { value -> this.list[value].show() },
        )
    }

    private fun createArchive() {
        println("Введите название нового архива:")
        val name = Scanner(System.`in`).nextLine()
        list.add(Archive(name))
    }

}