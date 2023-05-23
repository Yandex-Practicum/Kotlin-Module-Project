import kotlin.system.exitProcess

class MenuArchiveCollection () : ViewInterface {
    override val title: String = "меню имеющихся архивов"
    override val mapOfMenu: MutableMap<String, () -> Unit> = mutableMapOf()

    override fun prepareToView() {
        mapOfMenu.put("Создать архив") {menu.showCreateMenu(MenuCreateArchive())}
        for (key in NoteArchiveCollection.noteArchiveCollection.keys) {
            mapOfMenu.put(NoteArchiveCollection.noteArchiveCollection[key]!!.name){menu.showViewMenu(MenuViewArchive(key))}
        }
        mapOfMenu.put("Выход") { exitProcess(0) }
    }

}