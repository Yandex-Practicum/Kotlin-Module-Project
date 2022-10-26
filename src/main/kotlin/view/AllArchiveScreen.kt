package view

import presenter.Presenter
import java.util.*

class AllArchiveScreen(presenter: Presenter,  function: () -> (Unit)) : Screen(presenter, function ) {
    private val scanner = Scanner(System.`in`)
    override fun show() {
    println("Screen #1______AllArchiveScreen_______")
        println("+ - создать архив\n" +
                "0 - выход\n")
        println("choose archive: ")
        if (presenter.archives.size>0){
            presenter.archives.forEachIndexed { index, archive ->
                println("${index + 1} - ${archive.name}")
            }
        }else{
            println("архивов пока нет")
        }
        println("_______________")
                    while (true) {
                        val command = scanner.nextLine()
                        when (command) {
                            "0" -> {
                                println("Bye Bye...")
                                onBackPressed.invoke()
                            }
                            "+" -> {
                                ArchiveCreationScreen(presenter,::show).show()
                            }
                            else -> {
                                try {
                                    val archive = presenter.chooseArchive(command.toInt())
                                    if (archive != null) {
                                        NoteListScreen(archive, presenter, ::show).show()
                                    } else {
                                        println("нет такого значения")
                                    }
                                } catch (e: NumberFormatException) {
                                    println("некорректное значение")
                                }
                            }
                        }
                    }
    }
}