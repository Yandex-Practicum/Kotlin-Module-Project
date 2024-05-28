import java.util.InputMismatchException
import java.util.Scanner

open class Menu<T> : MenuInterface<T> {
    var isOptionWrongType = false
    var isEmptyRecordDescription = false
    override fun showMenu(
        recordListMessage: String, createRecordMessage: String, exitMessage: String,
        mapOfRecords: MutableMap<Int, T>?
    ) {
        println(recordListMessage)
        println(createRecordMessage)
        mapOfRecords?.forEach { record ->
            println("${record.key}. ${record.value.toString()}")
        }
        var menuNumberForExit = 1
        if (!mapOfRecords?.isEmpty()!!) {
            menuNumberForExit = mapOfRecords.keys.last().plus(1)
        }
        println("$menuNumberForExit. $exitMessage")
        print("Введите номер команды: ")
    }

    override fun getRecordId(mapOfRecords: MutableMap<Int, T>?): Int {
        var idOfRecord = 1
        if (mapOfRecords!!.isNotEmpty()) {
            idOfRecord = mapOfRecords.keys.last().plus(1)
        }
        return idOfRecord
    }

    override fun checkRecordDescription(recordDescription: String) {
        if (recordDescription.isBlank() || recordDescription.isEmpty()) {
            print("Описание не может быть пустым, попробуйте еще раз: ")
            isEmptyRecordDescription = true
        } else if (recordDescription.isNotEmpty()) {
            isEmptyRecordDescription = false
        }
    }

    override fun addRecord(recordId: Int, record: T, mapOfRecords: MutableMap<Int, T>?) {
        mapOfRecords?.put(recordId, record)
    }

    override fun getMenuOption(): Int {
        var menuOption = 0

        try {
            menuOption = Scanner(System.`in`).nextInt()
            isOptionWrongType = false
        } catch (e: InputMismatchException) {
            println("Введен неверный тип команды, попробуйте еще раз:")
            isOptionWrongType = true
        }

        return menuOption
    }

    override fun menuOptionValidate(menuOption: Int, mapOfRecords: MutableMap<Int, T>?) {
        if (
            (mapOfRecords?.isEmpty() == true && menuOption !in 0..1)
            || (mapOfRecords?.isNotEmpty() == true && menuOption !in 0..mapOfRecords.size.plus(1))
        ) {
            println("Команды не существует, попробуйте еще раз:")
        }
    }

    override fun exitFromMenuOption(mapOfRecords: MutableMap<Int, T>?): Int {
        var optionToReturn = 1
        if (mapOfRecords!!.isNotEmpty()) {
            optionToReturn = mapOfRecords.keys.last().plus(1)
        }
        return optionToReturn
    }
}

class ArchiveMenu : Menu<Archive>() {
    var mapOfArchives: MutableMap<Int, Archive> = mutableMapOf()
    fun showArchiveMenu() {
        super.showMenu(
            "Список архивов:",
            "0. Создать архив",
            "Выход",
            mapOfArchives
        )
    }

    fun createArchive() {
        print("Добавить архив: ")
        var archiveDescription = Scanner(System.`in`).nextLine()
        checkRecordDescription(archiveDescription)
        while (isEmptyRecordDescription) {
            archiveDescription = Scanner(System.`in`).nextLine()
            checkRecordDescription(archiveDescription)
        }
        val mapOfNotes: MutableMap<Int, Note> = mutableMapOf()
        val archive = Archive(archiveDescription, mapOfNotes)
        super.addRecord(getRecordId(mapOfArchives), archive, mapOfArchives)
    }
}

class NoteMenu : Menu<Note>() {
    fun showNoteMenu(mapOfNotes: MutableMap<Int, Note>?) {
        super.showMenu(
            "Список заметок:",
            "0. Добавить заметку",
            "Вернутся к списку архивов",
            mapOfNotes
        )
    }

    fun addNoteToArchive(mapOfNotes: MutableMap<Int, Note>?) {
        print("Добавить заметку: ")
        var noteDescription = Scanner(System.`in`).nextLine()
        checkRecordDescription(noteDescription)
        while (isEmptyRecordDescription) {
            noteDescription = Scanner(System.`in`).nextLine()
            checkRecordDescription(noteDescription)
        }
        val note = Note(noteDescription)
        super.addRecord(getRecordId(mapOfNotes), note, mapOfNotes)
    }
}