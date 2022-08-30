fun main() {
    // ваш код начнется здесь
    // вы не должны ограничиваться только классом Main и можете создавать свои классы по необходимости
    val listOfArchives = ListOfArchives()
    val newArchive = ArchiveOfNotes("newArchive", listOfArchives)
    val newNote = Note("newNote", newArchive)
    //newNote.content = "NoteNoteNote"
    //newArchive.archiveOfNotes.add(newNote)
    //listOfArchives.listOfArchives.add(newArchive)
    var currentMenu = listOfArchives
    val menu = MenuScreen(listOfArchives, null)
    val backNumber = menu.titlesList.size + 1
    val newInput = Logic()
    val regexCheck = "[0-9]".toRegex()

    fun printMenu() {
        println("0. Создать архив")
        for (i in menu.titlesList.indices){
            println("${i + 1}. ${menu.titlesList[i]}")
        }
        println("$backNumber. Выход")
    }
    printMenu()
    while(true) {
        val userInput = newInput.askForInput()
        if (userInput.matches(regexCheck))
        when (newInput.askForInput().toInt()) {
            backNumber -> return

            else -> return
        }
    }
//in menu.keys //if menu will be a map of menu option number and a lambda

}
