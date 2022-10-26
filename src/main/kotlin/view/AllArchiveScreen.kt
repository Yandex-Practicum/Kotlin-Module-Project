package view

import presenter.Presenter
import java.util.*

class AllArchiveScreen(presenter: Presenter,  function: () -> (Unit)) : Screen(presenter, function ) {
    override fun show() {
    println("Screen #1______основное меню_______")
        println("+ - создать архив\n" +
                "0 - выход\n")
        println("выберите архив по номеру: ")
        if (presenter.archives.size>0){
            presenter.archives.forEachIndexed { index, archive ->
                println("${index + 1} - ${archive.name}")
            }
        }else{
            println("архивов пока нет")
        }
        println("_______________")
                    while (true) {
                        when (val command = scanner.nextLine()) {
                            "0" -> {
                                println("Пока...")
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