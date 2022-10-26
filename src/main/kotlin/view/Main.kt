import presenter.Presenter
import view.AllArchiveScreen

import java.util.*
import kotlin.system.exitProcess


fun main() {
    val scanner = Scanner(System.`in`)
   AllArchiveScreen(Presenter, ::exit).show()



}

 fun exit() {
     exitProcess(0)
 }
