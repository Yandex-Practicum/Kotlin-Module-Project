import kotlin.system.exitProcess
import java.util.Scanner

class ArchiveScreen(private val archiveList: MutableList<Archive>) : Screen<Archive>("архив", archiveList){
    override fun goBack() {
        exitProcess(1)
    }

    override fun add() {
        println("Создание нового архива.\nВведите имя нового архива. Для отмены операции введите Отмена")
        val name = Scanner(System.`in`).nextLine()
        if (name == "Отмена") {
            println("Действие отменено.\n")
            show()
            return
        }
        archiveList.add(Archive(name, mutableListOf()))
        println("Архив заметок добавлен.\n")
        show()
    }

    override fun select(i : Int) {
        println("Открываем архив ${archiveList[i-1]}")
        val archive = OpenArchive(archiveList[i-1].notesArchive, this)
        archive.show()
    }
}