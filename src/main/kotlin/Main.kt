import java.util.Scanner

interface IUserInput {
    val scanner: Scanner
        get() = Scanner(System.`in`)

    fun userInputCreate(): String


}

interface IUserChoice {
    val scanner: Scanner
        get() = Scanner(System.`in`)

    fun userInputChoice(): Int

}

abstract class Menu() {

    /*open fun createMenu() {
        while (true) {
            println(
                "Меню архивов:\n" +
                        "0. Создать архив\n" +
                        "1. Это мой уже созданный архив\n" +
                        "2. Выход "
            )
            when (userInputChoice()) {
                0 -> createArchive()
                1 -> choiceArchive()
                2 -> return
            }
        }

    }*/

    open fun createMenuData() {

    }
}

class MenuImpl() {
    val archiveMenu: ArchiveMenu = ArchiveMenu()

    fun startProgramm() {
        archiveMenu.createArchiveMenu()

    }

}

class ArchiveMenu : Menu(), IUserChoice {
    var cacheArch: ArrayList<Archive> = ArrayList()

    fun createArchiveMenu() {
        while (true) {
            println(
                "Меню архивов:\n" +
                        "0. Создать архив\n" +
                        "1. Это мой уже созданный архив\n" +
                        "2. Выход "
            )
            when (userInputChoice()) {
                0 -> createArchive()
                1 -> {
                    if (archivesCollectionIsEmpty()) {
                        break
                    } else {
                        choiceArchive()
                    }
                }
                2 -> return
            }

        }
        createArchiveMenu()
    }

    fun createArchive() {
        println("Введите название архива:")
        val result = Archive()
        cacheArch.add(result)
    }


    fun choiceArchive() {
        println("Выберите архив:")
        val pickArchive = show()
        openNotesList(cacheArch[pickArchive])

    }
    //??????

    fun openNotesList(archive: Archive) {
        archive.notesMenu.createNotesMenu()
    }

    fun archivesCollectionIsEmpty(): Boolean {
        println("Нет архивов")
        return cacheArch.isEmpty()
    }

    fun show(): Int {
        println("Список архивов:")
        for (i in 0 until cacheArch.size) {
            println("\n$i)${cacheArch[i]}")
        }
        val choise = userInputChoice()
        return choise
    }

    override fun userInputChoice(): Int {
        val temp = scanner.nextInt()
        return temp
    }

}

class NotesMenu : IUserChoice {
    var notesCollection: ArrayList<Notes> = ArrayList()

    fun createNotesMenu() {
        while (true) {
            println(
                "Меню заметок:\n" +
                        "0. Это моя уже созданная заметка\n" +
                        "1. Создать заметку\n" +
                        "2. Выход "
            )
            when (userInputChoice()) {
                0 -> {
                    if (notesCollectionIsEmpty()) break
                    choiceNote()
                }
                1 -> createNotes()
                2 -> return
            }
        }
        createNotesMenu()

    }

    fun createNotes() {
        println("Введите заметку:")
        val result = Notes()
        notesCollection.add(result)
    }

    fun choiceNote() {
        println("Выберите заметку:")
        val pickNote = show()
        openNote(notesCollection[pickNote])
    }

    fun openNote(note: Notes) {
        println("Выбранная заметка:$note.name")
        return
    }

    fun notesCollectionIsEmpty(): Boolean {
        println("Нет заметок")
        return notesCollection.isEmpty()
    }

    fun show(): Int {
        println("Список заметок:")
        for (i in 0 until notesCollection.size) {
            println("\n$i)${notesCollection[i]}")
        }
        val choise = userInputChoice()
        return choise
    }

    override fun userInputChoice(): Int {
        val temp = scanner.nextInt()
        return temp
    }

}

class Archive() : IUserInput {
    val name = userInputCreate()
    val notesMenu: NotesMenu = NotesMenu()


    override fun userInputCreate(): String {
        val temp = scanner.nextLine()
        println("Архив добавлен")
        return temp
    }


    override fun toString(): String {
        return name
    }

}

class Notes() : IUserInput {
    val name: String = userInputCreate()

    override fun userInputCreate(): String {
        val temp = scanner.nextLine()
        println("Заметка добавлена")
        return temp
    }

    override fun toString(): String {
        return name
    }

}

fun main() {
    val menuImplementation: MenuImpl = MenuImpl()
    menuImplementation.startProgramm()

}
