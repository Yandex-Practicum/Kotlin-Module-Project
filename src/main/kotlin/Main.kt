import java.util.Scanner
import kotlin.system.exitProcess

val archives = mutableListOf<Archive>()

fun showMenu(){
    val menu = MenuNavi("Список архивов")
    menu.menuItems.add("Создать архив" to {createArchive()})
    archives.forEachIndexed {index, archive ->
        menu.menuItems.add(archive.name to {showArchMenu(index)})
    }
    menu.funMenu{ exitProcess(0) }
}

fun createArchive() {
    println("Введите имя архива")
    var name = Scanner(System.`in`).nextLine()
    while (name.trim().isEmpty()) {
        println("Имя архива должно содержать хотя бы 1 символ")
        name = Scanner(System.`in`).nextLine()
    }
    archives.add(Archive(name))
    showMenu()
}

fun showArchMenu(archIndex: Int) {
    val archive = archives[archIndex]
    val menu = MenuNavi("Список заметок")
    menu.menuItems.add("Создать заметку" to {createNote(archive)})
    archive.notes.forEachIndexed { index, note ->
        menu.menuItems.add(note.name to { showNoteMenu(archive, index) })
    }
    menu.funMenu{showMenu()}
}

fun createNote(archive: Archive) {
    println("Введите имя заметки")
    var name = Scanner(System.`in`).nextLine()
    while (name.trim().isEmpty()) {
        println("Имя заметки должно содержать хотя бы 1 символ")
        name = Scanner(System.`in`).nextLine()
    }

println("Введите текст заметки:")
    var text = Scanner(System.`in`).nextLine()
    while (text.trim().isEmpty()) {
        println("В заметке пусто, повторите ввод")
        text = Scanner(System.`in`).nextLine()
}

archive.notes.add(Note(name, text))
println("Заметка '$name' создана.")
showArchMenu(archives.indexOf(archive))
}

fun showNoteMenu(archive: Archive, noteIndex: Int) {
    val note = archive.notes[noteIndex]
    println("Заметка: ${note.name}")
    println("Текст: ${note.text}")
    println("Для возврата нажмите Enter или введите любой символ")
    readlnOrNull()
    showArchMenu(archives.indexOf(archive))
}

fun main(args: Array<String>) {
    println("Приложение Заметки")
    showMenu()

}