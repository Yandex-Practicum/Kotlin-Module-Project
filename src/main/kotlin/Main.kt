fun main() {
    // ваш код начнется здесь
    // вы не должны ограничиваться только классом Main и можете создавать свои классы по необходимости
    //val listOfArchives = ListOfArchives()
    //val newArchive = ArchiveOfNotes("newArchive", listOfArchives)
    //val newNote = Note("newNote", newArchive)
    //newNote.content = "NoteNoteNote"
    //newArchive.archiveOfNotes.add(newNote)
    //listOfArchives.listOfArchives.add(newArchive)
    var listOfArchivesMenu = ListOfArchives()
    var listOfNotesMenu: ArchiveOfNotes? = null
    var noteContent: Note? = null
//    val menu = MenuScreen(listOfArchives, null)
    val newInput = Logic()
//    val x = currentMenu.getTitleList()
    fun printMenu(currentMenu: ListOfArchives, returnNumber: Int) {
        println("0. Создать архив")
        for (each in currentMenu.titlesList) {
            println("${each.key}. $each")
        }
        println("$returnNumber. Выход")
    }
    while (true) {
        if (listOfNotesMenu == null && noteContent == null) {
            val returnNumber = listOfArchivesMenu.titlesList.size + 1
            printMenu(listOfArchivesMenu, returnNumber)
            val userInput =
                newInput.askForInput("Please, choose an option and enter a corresponding number")
                    .toInt()
            if (!listOfArchivesMenu.titlesList.keys.contains(userInput) &&
                userInput != 0 && userInput != returnNumber
            ) {
                continue
            }
            when (userInput) {
                returnNumber -> return
                0 -> {
                    val newTitle = newInput.askForInput("Please, input a title")
                    listOfArchivesMenu.addContent(newTitle, listOfArchivesMenu)
                    continue
                }
                else -> {
                    listOfNotesMenu = listOfArchivesMenu.titlesList[userInput]
                    continue
                }
            }
        } else if (listOfNotesMenu != null && noteContent == null) {
            val returnNumber = listOfNotesMenu.titlesList.size + 1
            listOfNotesMenu.printMenu(listOfNotesMenu, returnNumber)
            val userInput =
                newInput.askForInput("Please, choose an option and enter a corresponding number")
                    .toInt()
            if (!listOfNotesMenu.titlesList.keys.contains(userInput) &&
                userInput != 0 && userInput != returnNumber
            ) {
                continue
            }
            when (userInput) {
                returnNumber -> {
                    listOfNotesMenu = null
                    continue
                }
                0 -> {
                    val newTitle = newInput.askForInput("Please, input a title")
                    listOfNotesMenu.addContent(newTitle, listOfNotesMenu)
                    continue
                }
                else -> {
                    noteContent = listOfNotesMenu.titlesList[userInput]
                    println(noteContent?.title)
                    noteContent = null
                    continue
                }
            }
        }
    }
}
//in menu.keys //if menu will be a map of menu option number and a lambda

//    val arrayUtil = ArrayUtil<Int>(arrayOf(1,2,3,4,5))
//    arrayUtil.findElement(3) {index, element ->
//        println("Index $index")
//        println("Element $element")
//    }
//
//
//
//}
//
//class ArrayUtil<T>(private val array:Array<Int>){
//    fun findElement(element: Int, foundElement:(index:Int, element: Int?) -> Unit){
//        for(i in array.indices){
//            if(array[i] == element){
//                foundElement(i, array[i])
//                return
//            }
//        }
//        foundElement(-1, null)
//    }
//}