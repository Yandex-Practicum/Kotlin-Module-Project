package view

import presenter.Presenter
import java.util.*

class AllArchiveScreen(presenter: Presenter) : Screen(presenter) {
    val scanner = Scanner(System.`in`)
//    val archiveCreationScreen = ArchiveCreationScreen(presenter)
    override fun show() {
    println("_______AllArchiveScreen________")
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
//                        println("1  $command")

                        when (command) {
                            "0" -> {
                                println("Bye Bye...")
                                return
                            }

                            "+" -> {
                                presenter.archiveCreationScreen.show()
                            }

                            else -> {
                                try {
//                                    println(2)
                                    val archive = presenter.chooseArchive(command.toInt())
                                    if (archive != null) {
                                        println("U chose  ${archive.name}")
                                        //next screen
                                        NoteListScreen(archive, presenter).show()
                                    } else {
                                        println("нет такого значения")
//                                        scanner.next()
                                    }
                                } catch (e: NumberFormatException) {
                                    println("некорректное значение")
//                                    scanner.next()
                                    continue
                                }
//                                catch (e: NumberFormatException) {
//                                    println("NumberFormatException")
//                                    scanner.next()
//                                    continue
//                                }
                            }
                        }
                    }
    }
}

//            while (true) {
//                try {
//                    val archive = presenter.chooseArchive(scanner.nextInt())
//                    if (archive != null) {
//                        println("U chose  ${archive.name}")
//
//                    } else {
//                        println("нет такого значения")
//                    }
//                } catch (e: InputMismatchException) {
//                    println("некорректное значение")
//                    scanner.next()
//                    continue
//                }
//            }