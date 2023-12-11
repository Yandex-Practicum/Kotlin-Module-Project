fun main() {
    showMainMenu()
}
var mainMenuElements: MutableList<Archive> = mutableListOf()
fun showMainMenu() {
    val onCreate: (MutableList<Note>) -> Unit = { _ -> createArchive(mainMenuElements) }
    val onSelect: (Menu) -> Unit = { archive: Menu -> showNotesMenu(archive as Archive) }
    val onExit: () -> Unit = { println("Завершение программы") }
    MenuMaker.showMenu(TypeOfMenu.ARCHIVE, mainMenuElements, onCreate, onSelect, onExit)
}
fun showNotesMenu(archive: Archive) {
    val onCreate: (MutableList<Note>) -> Unit = { archiveWithNotes -> createNote(archiveWithNotes) }
    val onSelect: (Menu) -> Unit = { note -> (note as Note).readNote() }
    val onExit: (() -> Unit) = { println("Выход в меню архивов \n") }
    MenuMaker.showMenu(TypeOfMenu.NOTE, archive.notes, onCreate, onSelect, onExit)
}