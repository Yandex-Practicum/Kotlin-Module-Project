import base_screens.CreateItemScreen
import data.Archive
import data.Archives

class CreateArchiveScreen : CreateItemScreen<Archives, Archive>() {
    override fun showMenu() {
        ConsoleUtils.showMenu("0-выход \'Имя архива\'-создание архива с именем")
    }

    override fun createContent(text: String) {
        if (text.isEmpty()) {
            ConsoleUtils.write("Имя архива не может быть пустым")
            return
        }
        item!!.content.add(Archive((text)))
        ConsoleUtils.write("Архив с именем $text создан")
    }
}