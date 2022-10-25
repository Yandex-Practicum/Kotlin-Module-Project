package view

import presenter.Presenter
import java.util.*

class AllArchiveScreen(presenter: Presenter) : Screen(presenter) {
    val scanner = Scanner(System.`in`)

    override fun show() {
        if (presenter.archives.size>0){
            println("choose archive: ")
            presenter.archives.forEachIndexed { index, archive ->
                println("${index + 1} - ${archive.name}")
            }

            while (true) {
                try {
                    val archive = presenter.chooseArchive(scanner.nextInt())
                    if (archive != null) {
                        println("U chose  ${archive.name}")

                    } else {
                        println("нет такого значения")
                    }
                } catch (e: InputMismatchException) {
                    println("некорректное значение")
                    scanner.next()
                    continue
                }
            }

        }else{
            println("пока нету архивов ")
        }





    }
}