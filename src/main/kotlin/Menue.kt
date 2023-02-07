enum class Menu(val menuList: String) {
    CHOSEARCHIVE(menuList = "0. Create a new archive \n1. Chose one \n2. Exit"),
    CREATEARCHIVE(menuList = "Enter name of new archive, or 0 to Go Back..."),
    CHOSENOTE(menuList = "0. Create a new note \n1. Chose one  \n2. Go Back"),
    CREATENOTE(menuList = "0. Enter name of new note  \n1. Enter a text of the Note \n 2. Go Back"),
    NOTEVIEW (menuList = "Type 0 to go back")
}