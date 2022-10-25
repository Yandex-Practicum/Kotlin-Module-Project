package view

import presenter.Presenter
import java.util.*

class AllArchiveScreen(presenter: Presenter) : Screen(presenter) {
    val scanner = Scanner(System.`in`)

    override fun show() {
        println("_______________")
        println("FIRST SCREEN")
        println("+ - создать архив\n" +
                "0 - выход\n")
        println("choose archive: ")
        if (presenter.archives.size>0){
            presenter.archives.forEachIndexed { index, archive ->
                println("${index + 1} - ${archive.name}")
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

        }else{
            println("архивов пока нет")
        }
        println("_______________")
    }
}