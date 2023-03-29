import java.util.*
import kotlin.collections.ArrayList

object NoteTools {
    private val menu: MutableMap<Int, List<String>> = mutableMapOf()

    init {
        onCreate()
    }

    fun printContext(type: TitleTypes) {
        when (type) {
            TitleTypes.HEAD -> printHeadTitle()
            TitleTypes.ARCHIVES -> printArchiveTitle()
            TitleTypes.NOTES -> printNotesTitle()
        }
    }

    fun printArchiveNotesHead(titleType: TitleTypes) {
        val item: MutableList<String> = mutableListOf()
        val s = titleType.text.expandBySymbols(10, ' ')
        item.add("")
        item.add("***********************************************************")
        item.add("*                   Меню работы $s                *")
        item.add("***********************************************************")
        printList(item)
    }

    fun printCreateNewArchiveHead() {
        val item: MutableList<String> = mutableListOf()
        item.add("**************** СОЗДАНИЕ НОВОГО АРХИВА *******************")
        printList(item)
    }

    fun printCreateNewNoteHead() {
        val item: MutableList<String> = mutableListOf()
        item.add("**************** СОЗДАНИЕ НОВОЙ ЗАМЕТКИ *******************")
        printList(item)
    }

    fun printAllArchivesHead() {
        val item: MutableList<String> = mutableListOf()
        item.add("****************** СПИСОК ВСЕХ АРХИВОВ ********************")
        printList(item)
    }

    fun printNoteHead() {
        val item: MutableList<String> = mutableListOf()
        item.add("********************* ВЫВОД ЗАМЕТКИ ***********************")
        printList(item)
    }

    fun printNoteCreatedHead() {
        val item: MutableList<String> = mutableListOf()
        item.add("**************** СОЗДАНА НОВАЯ ЗАМЕТКА *******************")
        printList(item)
    }

    fun printAllNotesHead() {
        val item: MutableList<String> = mutableListOf()
        item.add("****************** СПИСОК ВСЕХ ЗАМЕТОК ********************")
        printList(item)
    }

    private fun onCreate() {
        menu[TitleTypes.HEAD.ordinal] = createMenuHead()
        menu[TitleTypes.ARCHIVES.ordinal] = createArchivesTitles()
        menu[TitleTypes.NOTES.ordinal] = createNotesTitles()
    }

    private fun createMenuHead(): List<String> {
        val menu: MutableList<String> = mutableListOf()
        menu.add("***********************************************************")
        menu.add("*                     Яндекс Практикум                    *")
        menu.add("*            Консольное приложение для заметок            *")
        menu.add("*                       by ANV-SRB                        *")
        menu.add("***********************************************************")
        return menu
    }

    private fun printHeadTitle() {
        printItem(TitleTypes.HEAD.ordinal)
    }

    private fun printArchiveTitle() {
        printItem(TitleTypes.ARCHIVES.ordinal)
    }

    private fun printNotesTitle() {
        printItem(TitleTypes.NOTES.ordinal)
    }

    private fun printList(item: MutableList<String>) {
        item.let { list ->
            list.forEach { println(it) }
        }

    }

    private fun printItem(item: Int?) {
        if (item != null) {
            menu[item]?.let { list ->
                list.forEach { println(it) }
            }
        }
    }

    private fun createArchivesTitles(): List<String> {
        val titles: ArrayList<String> = arrayListOf()
        titles.add(oneTitleCreate(TitleNamesText.EXIT.order, TitleNamesText.EXIT.text))
        titles.add(oneTitleCreate(TitleNamesText.CREATE_ARCHIVE.order, TitleNamesText.CREATE_ARCHIVE.text))
        titles.add(oneTitleCreate(TitleNamesText.SELECT_ARCHIVE.order, TitleNamesText.SELECT_ARCHIVE.text))
        return titles
    }

    private fun createNotesTitles(): List<String> {
        val titles: ArrayList<String> = arrayListOf()
        titles.add(oneTitleCreate(TitleNamesText.EXIT.order, TitleNamesText.EXIT.text))
        titles.add(oneTitleCreate(TitleNamesText.CREATE_NOTE.order, TitleNamesText.CREATE_NOTE.text))
        titles.add(oneTitleCreate(TitleNamesText.SELECT_NOTE.order, TitleNamesText.SELECT_NOTE.text))
        return titles
    }

    private fun oneTitleCreate(num: Int, title: String): String {
        return "$num. $title"
    }

    private var consoleInpScanner = Scanner(System.`in`)
    fun waitUserResponse(waitType: UserResponseType, minVal: Int, maxVal: Int): String {
        when (waitType) {
            UserResponseType.SELECTED_MENU -> {
                print("Введите номер меню: ")
                while (true) {
                    val inp = consoleInpScanner.nextLine()
                    val num: Int? = inp.toIntOrNull()
                    if (num != null) {
                        if (num in minVal..maxVal) {
                            return inp
                        } else println("Введенное число: $num не в допустимом диапазоне, попробуйте еще раз")
                    } else println("Некорректный ввод, попробуйте еще раз")
                }
            }

            else -> return consoleInpScanner.nextLine()
        }
    }
}

enum class TitleNamesText(val order: Int, val text: String) {
    EXIT(1, "Выход"),
    CREATE_ARCHIVE(2, "Создать архив"),
    SELECT_ARCHIVE(3, "Выбрать архив"),

    CREATE_NOTE(2, "Создать заметку"),
    SELECT_NOTE(3, "Выбрать заметку"),
}

enum class TitleTypes(val text: String) {
    HEAD("ЗАГОЛОВОК"),
    ARCHIVES("АРХИВЫ"),
    NOTES("ЗАМЕТКИ"),
}

enum class UserResponseType {
    SELECTED_MENU,
    TEXT,
}

fun String.expandBySymbols(setLen: Int, symbol: Char): String {
    var res = this
    for (i in res.length until setLen) res += symbol.toString()
    return res
}
