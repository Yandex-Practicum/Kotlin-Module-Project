package screenLogic


import entities.Archive
import entities.MenuItem
import screens.BaseScreen
import screens.archive.ArchiveScreen
import screens.archive.ArchiveSelectionScreen
import screens.interfaces.Screen
import screens.note.NoteCreatingScreen
import screens.note.NoteScreen
import screens.note.NoteSelectionScreen

class EntityScreenLogic(private val entity: Screen) {

    // формирование меню в зависимости от экрана
    fun createMenu(archive: Archive?, archives: MutableList<Archive>) {
        entity.menu.clear()

        when (entity) {
            is ArchiveScreen -> {
                ArchiveScreen.menu.add(MenuItem("Перейти к предыдущему экрану") {
                    ArchiveSelectionScreen.show(
                        archives
                    )
                })

                entity.menu.add(MenuItem("Добавить заметку") {
                    archive?.let {
                        NoteCreatingScreen.create(
                            it,
                            archives
                        )
                    }
                })
            }

            is NoteScreen -> {
                entity.menu.add(MenuItem("Перейти к предыдущему экрану") {
                    archive?.let {
                        ArchiveScreen.show(
                            it,
                            archives
                        )
                    }
                })
            }

            is ArchiveSelectionScreen -> {
                ArchiveSelectionScreen.menu.add(
                    MenuItem("Перейти к предыдущему экрану") { BaseScreen.start() }
                )

                for (a in archives) {
                    val menuItem = MenuItem(
                        a.name
                    ) { ArchiveScreen.show(a, archives) }
                    ArchiveSelectionScreen.menu.add(menuItem)
                }

                print("Список архивов: ")
            }

            is NoteSelectionScreen -> {
                NoteSelectionScreen.menu.add(
                    MenuItem("Перейти к предыдущему экрану ") {
                        ArchiveSelectionScreen.show(
                            archives
                        )
                    }
                )

                for (note in archive?.notes!!) {
                    val menuItem = MenuItem(
                        note.name
                    ) { NoteScreen.show(note, archive, archives) }
                    NoteSelectionScreen.menu.add(menuItem)
                }
                NoteSelectionScreen.menu.add(
                    MenuItem("Создать заметку") { NoteCreatingScreen.create(archive, archives) }
                )
            }
        }
        entity.menuLogic.showMenu()
    }
}