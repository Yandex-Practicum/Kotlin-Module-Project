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
        var archiveName : String
        while (true){
        println("Введите название нового архива:")
            archiveName = Scanner(System.`in`).nextLine()
            if (archiveName.isEmpty()){
                println("Название не может быть пустым.")
                continue
            } else break
        }
        list.add(Archive(archiveName))
    }

}