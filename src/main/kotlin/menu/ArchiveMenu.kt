package menu

import entity.Archive
import java.util.*
import kotlin.system.exitProcess

class ArchiveMenu(private val data: ArrayList<Archive>): BaseMenu<Archive>(data) {
    override fun chooseCreate() = CREATE

    override fun add(scanner: Scanner) {
        println(ENTER_NAME)
        val name = scanner.nextLine()
        if (name == GO_BACK) {
            show()
            return
        }
        data.add(Archive(name, arrayListOf()))
        println(ARCHIVE_CREATED)
    }

    override fun open(elem: Archive) {
      NotesMenu(this,elem).show()
    }

    override fun printGoBack() {
       println("${data.size+1}. "+ EXIT)
    }

    companion object {
        const val GO_BACK = "Назад"
        const val CREATE = "0. Чтобы создать архив"
        const val ENTER_NAME = "Введите название архива или введите \"$GO_BACK\" для возвращения на предыдущий экран"
        const val EXIT = "Выйти из приложения"
        const val ARCHIVE_CREATED = "Архив создан"

    }

    override fun goBack() {
        exitProcess(1)
    }


}