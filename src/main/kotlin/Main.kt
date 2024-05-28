
fun main(args: Array<String>) {
//    println("Hello World!")

    val storage = Storage()

    var currentScreen: Screen? = Screen.MainScreen

    while(currentScreen != null) {

        val menuItem: Menu.MenuItem = currentScreen.show(storage)

        when(currentScreen) {

            Screen.MainScreen -> {

                when(menuItem.name) {

                    T_CREATE_ARCHIVE -> storage.createArchive()
                    T_SCREEN_EXIT    -> currentScreen = null
                    else             -> {
                        storage.setCurrentArchive(menuItem.name)
                        currentScreen = Screen.SelectNote
                    }
                }
            }

            Screen.SelectNote -> {

                when(menuItem.name) {

                    T_CREATE_NOTE    -> storage.createNote()
                    T_SCREEN_EXIT    -> currentScreen = Screen.MainScreen
                    else             -> {
                        storage.setCurrentNote(menuItem.name)
                        currentScreen = Screen.ShowNote
                    }
                }

            }

            Screen.ShowNote -> {

                when(menuItem.name) {

                    T_SCREEN_EXIT    -> currentScreen = Screen.SelectNote

                }
            }
        }
    }
}