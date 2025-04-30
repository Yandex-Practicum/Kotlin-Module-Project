import java.util.Scanner

class ArchiveScreen(val archives: MutableList<Archive>, var createArchiveScreen: CreateArchiveScreen? = null, var notesScreen: NotesScreen? =null): ScreenPrototype() {
    override fun display() {
        val size = archives.size
        println("Список архивов:\n")
        putMenu<Archive>(archives)
        val choise = Scanner(System.`in`).nextLine()
        when(choise?.toIntOrNull()){
            1->createArchiveScreen?.display()
            in 2..archives.size+1-> {
                notesScreen!!.archive = archives[choise!!.toIntOrNull()!!-2]
                notesScreen?.display()
            }
            archives.size+2-> return
            else -> {
                println("Некорректный ввод")
                this.display()
            }
        }
    }

}
