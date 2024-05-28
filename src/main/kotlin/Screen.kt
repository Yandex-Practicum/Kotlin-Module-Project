import Menu.MenuItem

abstract class Screen() {

    abstract fun show(storage: Storage): MenuItem

    // главный экран. выбор архива.
    object MainScreen : Screen()
    {
        override fun show(storage: Storage): MenuItem {

            val menu = Menu(T_ARCHIVES)

            menu.addMenuItem(MenuItem(T_CREATE_ARCHIVE))
            for(archName in storage.getArchives())
                menu.addMenuItem(MenuItem(archName))

            menu.addMenuItem(MenuItem(T_SCREEN_EXIT))

            return menu.selectMenuItem()
        }
    }

    // список заметок.
    object SelectNote : Screen()
    {
        override fun show(storage: Storage): MenuItem {

            val menu = Menu(T_NOTES + ". Текущий архив: ${storage.currentArchName}")

            menu.addMenuItem(MenuItem(T_CREATE_NOTE))
            if(storage.getNotes().isNotEmpty())
                for(note in storage.getNotes()) menu.addMenuItem(MenuItem(note))
            menu.addMenuItem(MenuItem(T_SCREEN_EXIT))

            return menu.selectMenuItem()
        }
    }

    // вывод заметки на экран.
    object ShowNote : Screen()
    {
        override fun show(storage: Storage): MenuItem {

            val menu = Menu(T_SCREEN_NOTE + "\n${storage.currentNoteText}")

            menu.addMenuItem(MenuItem(T_SCREEN_EXIT))

            return menu.selectMenuItem()
        }
    }
}

