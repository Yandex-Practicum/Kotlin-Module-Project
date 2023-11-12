import java.util.Scanner

class Screen {
    private val work = CreateAndChoice()
    private val scanner = Scanner(System.`in`)

    fun navigation() {
        val menu = Menu()
        var menuState = MenuState.ARCHIVE
        var selectedArchiveIndex = -1
        var selectedNoteIndex = -1

        while (true) {
            when (menuState) {
                MenuState.ARCHIVE -> {
                    menu.renderArchives(work.archivesList)
                }

                MenuState.NOTES -> menu.rendernotes(work.archivesList[selectedArchiveIndex].notes)
                MenuState.VIEW -> {
                    if (selectedArchiveIndex >= 0 && selectedNoteIndex >= 0) {
                        println(work.archivesList[selectedArchiveIndex].notes[selectedNoteIndex])
                    }
                    work.back()
                    menuState = MenuState.NOTES
                    continue
                }

                MenuState.CREATEARCHIVE -> {
                    work.createArchive()
                    menuState = MenuState.ARCHIVE
                    continue
                }

                MenuState.CREATENOTE -> {

                    work.addNoteToArchive(selectedArchiveIndex)
                    menuState = MenuState.NOTES
                    continue
                }
            }
            val selectedIndex = scanner.next().toIntOrNull()
            if (selectedIndex != null) {
                when {
                    selectedIndex == menu.menuItems.lastIndex -> {
                        when (menuState) {
                            MenuState.ARCHIVE -> break
                            MenuState.NOTES -> menuState = MenuState.ARCHIVE
                            else -> {}
                        }
                    }

                    selectedIndex == 0 -> {
                        when (menuState) {
                            MenuState.ARCHIVE -> menuState = MenuState.CREATEARCHIVE
                            MenuState.NOTES -> menuState = MenuState.CREATENOTE
                            else -> {}
                        }
                    }

                    selectedIndex < menu.menuItems.lastIndex -> {
                        when (menuState) {
                            MenuState.ARCHIVE -> {
                                selectedArchiveIndex = selectedIndex - 1
                                menuState = MenuState.NOTES
                            }

                            MenuState.NOTES -> {
                                selectedNoteIndex = selectedIndex - 1
                                menuState = MenuState.VIEW
                            }

                            else -> {}
                        }
                    }

                    else -> {
                        println("Неверный ввод.")
                        menuState = MenuState.ARCHIVE
                    }
                }
            } else {
                println("Неверный ввод.")
                when (menuState) {
                    MenuState.NOTES -> menuState = MenuState.NOTES
                    else -> {
                        menuState = MenuState.ARCHIVE
                    }
                }
            }
        }
    }
}