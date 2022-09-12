interface NavigatorItem {
    var title: String
    val parent: Folder?
    val TYPE_I: String
    val TYPE_R: String
    val TYPE_D: String
    val ENDING: String
}

class Note(
    override var title: String,
    private var content: String,
    override val parent: Folder?
) : NavigatorItem {

    override val TYPE_I: String = "Заметка"
    override val TYPE_R: String = "заметки"
    override val TYPE_D: String = "заметкy"
    override val ENDING: String = "а"

    override fun toString(): String = title
    fun toContent(): String = content
    fun saveToContent(sample: String) {
        content = sample
    }
}

class Folder(
    override var title: String,
    override val parent: Folder?
) : NavigatorItem {
    val items: MutableSet<NavigatorItem> = mutableSetOf()

    override val TYPE_I: String = "Архив"
    override val TYPE_R: String = "архива"
    override val TYPE_D: String = "архив"
    override val ENDING: String = ""

    override fun toString(): String = title
}

class Navigator (private val root: Folder) {
    private var currentFolder: Folder = root
    var isRunning: Boolean = true
    private val lengthOfItemName: Int
        get() = if (Style.WIDTH_SCREEN / 4 > 10) Style.WIDTH_SCREEN / 4 else 10

    private fun createItem(title: String) {
        val item: NavigatorItem = if (currentFolder != root) {
            val content = getFromInput("Введите текст заметки и нажмите ENTER:\n")
            Note(title, content, currentFolder)
        } else {
            Folder(title, currentFolder)
        }
        currentFolder.items.add(item)
        println("${item.TYPE_I} ${Style.ITEM_BORDER}$title${Style.ITEM_BORDER} создан${item.ENDING}")
    }

    private fun deleteItem(item: NavigatorItem) {
        while (true) {
            val input =
                getFromInput("Вы действительно хотите удалить ${item.TYPE_D} ${Style.ITEM_BORDER}${item}${Style.ITEM_BORDER}?(Y/N): ")
            if (input.uppercase() == "Y") {
                item.parent!!.items.remove(item)
                println("${item.TYPE_I} ${Style.ITEM_BORDER}${item}${Style.ITEM_BORDER} удален${item.ENDING}")
                return
            } else if (input.uppercase() == "N") return

            println("Недопустимый ввод, выполните повторно")
        }
    }

    private fun renameItem(item: NavigatorItem) {
        item.title = setTitleIfBusy(getFromInput("Введите новое имя ${item.TYPE_R}: ")).trim()
        println("${item.TYPE_I} переименован${item.ENDING}")
    }

    private fun openItem(item: NavigatorItem) {
        if (item.parent == root) {
            (item as Folder).also { currentFolder = it }
        } else {
            Style.printSampleInLineFormat(Style.ITEM_NOTE_MARKER + item.title, true)

            var sample = ((item as Note).toContent())
            if (sample.count() > Style.WIDTH_SCREEN) {
                var end = Style.WIDTH_SCREEN
                while (sample.count() > 0) {
                    if (sample.count() > Style.WIDTH_SCREEN) {
                        for (i in (Style.WIDTH_SCREEN - 1) downTo 0) if (sample[i].toString() == " ") {
                            end = i
                            break
                        }
                    } else end = sample.count()
                    println(sample.substring(0, end))
                    sample = sample.drop(end + 1)
                    end = Style.WIDTH_SCREEN
                }
            } else println(sample)

            Style.printSampleInLineFormat("конец файла", false)
        }
    }

    private fun editNote(item: Note) {
        openItem(item)
        val currentContent = item.toContent()
        val contentToAdd =
            getFromInput("Ведите текст, который необходимо добавить, и нажмите Enter:\n")
        val space = if (currentContent[currentContent.count() - 1].toString() == " ") "" else " "
        item.saveToContent(item.toContent() + space + contentToAdd)
        println("Текст добавлен к записке")
    }

    private fun levelBack() {
        if (currentFolder == root) isRunning = false else {
            currentFolder = root
        }
    }

    private fun showCurrentFolder() {
        if (root.items.size == 0) {
            println("Нет ни одного архива и ни одной заметки, холодно и одиноко")
            return
        }
        if (currentFolder != root && currentFolder.items.size == 0) {
            println("${currentFolder.TYPE_I} ${Style.ITEM_BORDER}${currentFolder}${Style.ITEM_BORDER} пуст")
            return
        }
        var titleMarker = ""
        val itemMarker: String
        if (currentFolder == root) {
            itemMarker = Style.ITEM_FOLDER_MARKER
        } else {
            itemMarker = Style.ITEM_NOTE_MARKER
            titleMarker = Style.ITEM_FOLDER_MARKER
        }
        Style.printSampleInLineFormat(titleMarker + currentFolder.title, true)

        var maxLenghtTitle = 0
        for (i in currentFolder.items) if (i.title.count() > maxLenghtTitle) maxLenghtTitle =
            i.title.count()

        if (maxLenghtTitle < (Style.WIDTH_SCREEN / 2 - 2 * Style.SPACE.count() - itemMarker.count() - 1)) {
            var isNextLine = false
            var previousTitleCount = 0
            for (i in currentFolder.items) {
                if (isNextLine) {
                    for (k in 1..(maxLenghtTitle - previousTitleCount + 1)) print(" ")
                    println(Style.SPACE + itemMarker + i)
                    isNextLine = false
                } else {
                    print(Style.SPACE + itemMarker + i)
                    isNextLine = true
                    previousTitleCount = i.title.count()
                }
            }
            if (isNextLine) println()
        } else for (i in currentFolder.items) println(Style.SPACE + itemMarker + i)

        Style.printSampleInLineFormat(Style.LINE_SYMBOL, false)
    }

    fun showCommands() {
        val subString1: String
        val subString2: String

        if (currentFolder == root) {
            subString1 = "архив"
            subString2 = "корневого каталога"
        } else {
            subString1 = "заметку"
            subString2 = "архива"
        }
        Style.printSampleInLineFormat("Доступные команды", true)
        println("${Style.SPACE}${COMMAND_HELP} - показать перечень доступных команд")
        println("${Style.SPACE}${COMMAND_LIST} - показать содержимое $subString2")
        println("${Style.SPACE}${COMMAND_CREATE} ИМЯ - создать $subString1")
        if (currentFolder.items.size > 0) {
            println("${Style.SPACE}${COMMAND_DELETE} ИМЯ - удалить $subString1")
            println("${Style.SPACE}${COMMAND_RENAME} ИМЯ - переименовать $subString1")
            println("${Style.SPACE}${COMMAND_OPEN} ИМЯ - открыть $subString1")
            if (currentFolder != root) println("${Style.SPACE}${COMMAND_EDIT} ИМЯ - редактировать $subString1")
        }
        print("${Style.SPACE}${COMMAND_BACK} - выйти из ")
        if (currentFolder == root) println("приложения") else println("архива ${Style.ITEM_BORDER}$currentFolder${Style.ITEM_BORDER}")
        Style.printSampleInLineFormat(Style.LINE_SYMBOL, false)
    }

    private fun setTitleIfBusy(title: String): String {
        if (currentFolder.items.isEmpty()) return setTitleToNameLenght(title)
        var sample = setTitleToNameLenght(title)
        var itemTypeString = "Объект"
        val titleSet: MutableSet<String> = mutableSetOf()
        for (i in currentFolder.items) {
            titleSet.add(i.title)
            itemTypeString = i.TYPE_I
        }
        while (true) {
            if (titleSet.add(sample)) return sample
            println("$itemTypeString с таким именем уже существует")
            sample = setTitleToNameLenght(getFromInput("Введите другое имя: "))
        }
    }

    private fun findItemToManage(title: String): NavigatorItem? {
        var itemTypeString = "Объект"
        var ending = ""
        for (i in currentFolder.items) {
            itemTypeString = i.TYPE_I
            ending = i.ENDING
            if (i.title == title) return i
        }
        println("$itemTypeString с именем ${Style.ITEM_BORDER}$title${Style.ITEM_BORDER} не найден$ending")
        return null
    }

    private fun isCommandAvailable(): Boolean {
        if (currentFolder.items.size > 0) return true
        println("Команда не доступна")
        return false
    }

    fun path(): String {
        return ("root" + (if (currentFolder != root) "/${currentFolder.title}" else "") + " -> ")
    }

    fun handleInput(input: String) {
        val title: String? =
            if (input.count() > LENGHT_OF_COMMAND) input.drop(LENGHT_OF_COMMAND).trim() else null
        val command = input.substring(0, LENGHT_OF_COMMAND)
        when (command) {
            COMMAND_HELP -> showCommands()
            COMMAND_LIST -> showCurrentFolder()
            COMMAND_BACK -> levelBack()
            else -> {
                if (command != COMMAND_CREATE &&
                    command != COMMAND_DELETE &&
                    command != COMMAND_RENAME &&
                    command != COMMAND_OPEN &&
                    command != COMMAND_EDIT
                ) {
                    println("Неизвестная команда. Введите '${COMMAND_HELP}' для справки")
                    return
                }
                if (title == null || title == "") {
                    println("Недопустимое имя")
                    return
                }
                if (command == COMMAND_CREATE) {
                    createItem(setTitleIfBusy(title))
                    return
                } else {
                    if (!isCommandAvailable()) return
                    if (findItemToManage(title) == null) return
                }
                when (command) {
                    COMMAND_DELETE -> deleteItem(findItemToManage(title)!!)
                    COMMAND_RENAME -> renameItem(findItemToManage(title)!!)
                    COMMAND_OPEN -> openItem(findItemToManage(title)!!)
                    COMMAND_EDIT -> editNote((findItemToManage(title)!!) as Note)
                }
            }
        }
    }

    fun getLenghtOfCommand(): Int = LENGHT_OF_COMMAND
    fun getCommandHelp(): String = COMMAND_HELP

    private fun setTitleToNameLenght(title: String): String {
        return if (title.count() > lengthOfItemName) {
            var sample = title
            while (sample.count() > lengthOfItemName) {
                println("Длина имени не может превышать $lengthOfItemName символ/ов")
                sample = getFromInput("Введите новое имя: ")
            }
            sample
        } else title
    }

    companion object {
        private const val LENGHT_OF_COMMAND: Int = 3
        private const val COMMAND_HELP: String = "cmd"
        private const val COMMAND_LIST: String = "lst"
        private const val COMMAND_CREATE: String = "set"
        private const val COMMAND_DELETE: String = "del"
        private const val COMMAND_RENAME: String = "ren"
        private const val COMMAND_OPEN: String = "get"
        private const val COMMAND_BACK: String = "out"
        private const val COMMAND_EDIT: String = "mod"
    }
}

object Style {
    const val WIDTH_SCREEN = 60
    val SPACE: String
        get() = setIndention(WIDTH_SCREEN / 20)
    const val ITEM_BORDER = "\""
    const val ITEM_FOLDER_MARKER = "[\u2263] "
    const val ITEM_NOTE_MARKER = "\u2338 "
    const val LINE_SYMBOL = "-"

    fun printSampleInLineFormat(sample: String, isSpace: Boolean) {
        val countLeft: Int =
            if (sample.count() < WIDTH_SCREEN) (WIDTH_SCREEN - sample.count()) / 2 else 0
        val space = if (isSpace) " " else ""
        var printString = ""
        if (countLeft > 0) {
            for (i in 1..countLeft - 1) printString = printString + LINE_SYMBOL
            printString = printString + space + sample + space
            for (i in 1..(WIDTH_SCREEN - printString.count())) printString =
                printString + LINE_SYMBOL
        } else {
            println(sample)
            return
        }
        println(printString)
    }

    fun setIndention(count: Int): String {
        if (count < 1) return ""
        var sample = ""
        for (i in 1..count) sample = "$sample "
        return sample
    }
}

fun getFromInput(query: String): String {
    var input: String? = null
    while (input == null || input == "") {
        print(query)
        input = readLine()
    }
    return input
}

fun main() {
    val title = "\"ЗАМЕТКИ\""
    println("*** Добро пожаловать в консольное приложение $title ***\n${Style.setIndention(4)}Здесь мы можем:")
    println("${Style.setIndention(11)}- создавать и просматривать заметки")
    println("${Style.setIndention(11)}- создавать и просматривать архивы с заметками")
    println("${Style.setIndention(11)}- переименовывать и удалять созданные элементы\n")
    println("${Style.setIndention(4)}Пока ничего нет, но давайте что-нибудь создадим\n")

    val navigator = Navigator(Folder("Корневой каталог", null))
    navigator.showCommands()
    while (navigator.isRunning) {
        val input = getFromInput(navigator.path())
        if (input.count() >= navigator.getLenghtOfCommand()) {
            navigator.handleInput(input)
        } else {
            println("Недопустимый ввод. Введите \"${navigator.getCommandHelp()}\" для справки")
        }
    }
    println("Работа приложения $title завершена.\nХорошего дня!")
}
