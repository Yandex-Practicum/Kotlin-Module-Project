import java.util.Scanner

class MainPage(name: String) : Page(name) {
    private val list: MutableList<Archive> = mutableListOf()
    override fun toString(): String {
        return "архив"
    }

    override fun show() {
        navigate(list)
    }

    override fun create() {
        println("Введите название нового архива:")
        val name = Scanner(System.`in`).nextLine()
        list.add(Archive(name))
    }

}