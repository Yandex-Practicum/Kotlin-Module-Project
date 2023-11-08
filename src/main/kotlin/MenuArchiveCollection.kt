import kotlin.system.exitProcess

class MenuArchiveCollection () : ViewInterface {
    override val title: String = "меню имеющихся архивов"
    override val mapMenu: MutableMap<String, () -> Unit> = mutableMapOf()

    override fun prepareToView() {
        mapMenu["Создать архив"] = {menu.showCreateMenu(CreateArchive())}
        for (key in NoteArchiveCollection.noteArchiveCollection.keys) {
            mapMenu[NoteArchiveCollection.noteArchiveCollection[key]!!.name] = {menu.showViewMenu(MenuArchive(key))}
        }
        mapMenu["Выход"] = { exitProcess(0) }
    }

}