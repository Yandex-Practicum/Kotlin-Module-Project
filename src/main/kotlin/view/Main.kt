import presenter.Presenter
import view.AllArchiveScreen

import java.util.*




fun main() {
    val scanner = Scanner(System.`in`)
    val allArchivesScreen = AllArchiveScreen(Presenter)

        allArchivesScreen.show()

}
