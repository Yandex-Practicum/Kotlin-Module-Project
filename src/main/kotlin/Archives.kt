//интерфейс для элементов списка, который передается в процедуру формирования меню
interface Selectable {
    val name: String //наименование пункта меню
    val onSelect: ()->Unit //процедура вызываемая при выборе пункта меню
}

//процедура формирования списка меню
fun <T: Selectable> setNavList(
    firstItemName: String, //название первого пункта меню
    firstItemFunction: () -> Unit, //процедура при вызове первого пункта меню
    itemsList: List<T>, //список с эелементами меню
    exitItemFunction: () -> Unit //процедура при вызове пункта выход
) {
    //первый пункт меню
    var arr: MutableMap<Int, NavItem> = mutableMapOf(1 to NavItem( firstItemName, firstItemFunction))
    var i: Int = 1
    //список элементов для меню
    for(a in itemsList) {
        i++
        arr.put(i, NavItem(a.name, a.onSelect))
    }
    //пункт выход
    arr.put(i+1, NavItem("Выход", exitItemFunction))
    Navigator.menu = arr
}

//заметка
class Note(override val name: String, val descriprion: String): Selectable {

    //при выборе заметки, выводим ее описание
    override val onSelect: ()->Unit = {
        println(descriprion)
    }
}

//архив - набор заметок
class Archive(override val name: String): Selectable {
    var notes: MutableList<Note> = mutableListOf()

    fun setNavigationList() {
        setNavList("Создать заметку", onCreateNote, notes, Archives.onSelect)
    }

    //при создании заметки запрашиваем название, описание, добавляем в список, обновляем список
    val onCreateNote: ()->Unit = {
        print("Введите название заметки: ")
        val noteName = Navigator.scanner.next()
        print("Введите текст заметки: ")
        val noteText = Navigator.scanner.next()
        notes.add(Note(noteName, noteText))
        onSelect()
    }

    //при выборе архива, формируем для него меню
    override val onSelect: ()->Unit = {
        setNavigationList()
    }
}

//база данных - набор архивов
object  Archives {
    var archives: MutableList<Archive> = mutableListOf()

    //при выборе запрашиваем имя нового архива, добавляем в список, обновляем меню
    val onCreateArchive: ()->Unit = {
        print("Введите название архива: ")
        archives.add(Archive(Navigator.scanner.next()))
        onSelect()
    }

    //при выходе в навигатор очищаем меню
    val onExit: ()->Unit = {
        Navigator.menu.clear()
    }

    //при возврате в этот пункт меню обновляем список
    val onSelect: ()->Unit = {
        setNavigationList()
    }

    //формируем список меню для начального экрана
    fun setNavigationList() {
        setNavList("Создать архив", onCreateArchive, archives, onExit)
    }

}






