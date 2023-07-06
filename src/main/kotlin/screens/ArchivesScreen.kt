import base_screens.ItemsScreen
import data.Archive
import data.Archives

class ArchivesScreen : ItemsScreen<Archives, Archive>() {

    init {
        selectItemScreen = SelectArchiveScreen()
        createItemScreen = CreateArchiveScreen()
    }

    override fun showMenu() {
        ConsoleUtils.showMenu("0-выход 1-создать архив 2-открыть архив")
    }

    override fun exit() {
        ConsoleUtils.write("Программа завершена")
    }
}