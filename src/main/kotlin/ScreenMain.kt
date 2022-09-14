
class ScreenMain : Screen (ScreenType.MAIN) {
    private val archives: MutableList<Archive> = mutableListOf()
    private val arcScreen = ScreenArchive()

    fun start() {
        while (true) {
            renderMenu(archives)
            when (val selectedMenuItem = selectMenuItem(archives.size)) {
                -2 -> { // exit program
                    println("\t...программа завершает работу, пока")
                    break
                }
                -1 -> addNewArchive() // add new item
                0 -> showErrorMessage(archives.isEmpty())
                else -> {
                    val arc = archives[selectedMenuItem-1]
                    println("\t...выбран архив '$arc'")
                    arcScreen.start(arc)
                }
            } //> when
        } //> while
    } //> start()

    private fun addNewArchive() {
        var name: String
        while (true) {
            print("Введите название нового архива: ")
            name = scanner.nextLine()
            if (!checkUniqueArcName(name)) {
                println("\t...такое имя архива уже существует, надо ввести уникальное имя")
                continue
            }
            if (name.isEmpty()) {
                println("\t...необходимо ввести не пустое имя")
                continue
            }
            break
        }
        archives.add(Archive(name))
        println("\t...добавлен новый архив '$name'")
    }

    private fun checkUniqueArcName(name: String): Boolean {
        for (arc in archives)
            if (arc.name == name)
                return false
        return true
    }

}