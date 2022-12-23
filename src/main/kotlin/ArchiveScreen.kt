import kotlin.system.exitProcess
class ArchiveScreen(private val archiveList: MutableList<Archive>) : Screen<Archive>("архив", archiveList)  {
    override fun back() {
        exitProcess(1)
    }

    override fun add() {
        println("Вы собираетесь создать архив.\nВведите его имя или -1, чтобы отменить действие:")
        val name = readLine()!!
        if (name == "-1") {
            println("Действие отменено!")
            show()
            return
        }
        archiveList.add(Archive(name, mutableListOf()))
        println("Архив успешно создан!")
        show()
    }

    override fun select(id: Int) {
        println("Открываем архив ${archiveList[id - 1]}...")
        val archive = OpenArchiveScreen(archiveList[id - 1].content, this)
        archive.show()
    }
}