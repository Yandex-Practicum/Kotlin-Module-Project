import base_screens.SelectItemScreen
import data.Archive
import data.Archives
import screens.NotesScreen

class SelectArchiveScreen : SelectItemScreen<Archives, Archive>() {

    override fun show(item: Archives): Archives {
        super.show(item)
        if (currentItem !== null)
            NotesScreen().show(currentItem!!)
        return item
    }

    override fun showMenu() {
        ConsoleUtils.showMenu("0-выход \'Имя архива\'-открытие архива с именем")
    }

    override fun select(text: String) {
        if (text.isEmpty()) {
            ConsoleUtils.write("Имя выбранного архива не должно быть пустым")
            return
        }
        currentItem = item!!.content.firstOrNull { it.name == text }
        if (currentItem == null) {
            ConsoleUtils.write("Такого архива не существует")
            return
        }
        return
    }
}