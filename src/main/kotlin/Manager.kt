import java.util.*

class Manager: Screen() {

    var listObjects: MutableList<Archive> = mutableListOf()
    override val createObject: String = "архив"

    override fun showObjects() {
        while (true) {
            Show(listObjects).show(createObject)
            if (InCommand().executeCommand(this, listObjects) == overModule) {
                break
            }
        }
    }

    override fun addObject() {
        println("Введите название архива: ")
        val nameArchive = Scanner(System.`in`).nextLine()
        listObjects.add(Archive(nameArchive))
        println("Архив $nameArchive создан.")
    }
}