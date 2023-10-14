import java.util.Scanner

class MainPage(name: String) : Page(name) {
    private val list: MutableList<Archive> = mutableListOf()
    override fun show() {
        navigate(list)
    }

    override fun create() {
        var archiveName: String
        while (true) {
            println("Введите название нового архива:")
            archiveName = Scanner(System.`in`).nextLine()
            if (checkEmpty(archiveName)) {
                continue
            } else {
                break
            }
        }
        list.add(Archive(archiveName))
    }

}