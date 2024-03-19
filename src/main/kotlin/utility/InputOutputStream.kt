package utility

import entity.Group
import entity.Note
import view.UIView
import java.text.SimpleDateFormat
import java.util.*

internal class InputOutputStream {
    private var id: Int = 0
    private val ui = UIView()

    // метод ввода строки
    private fun input(): String {
        val scanner = Scanner(System.`in`)
        var input = ""
        var flagInput = true
        while (flagInput) {
            if (scanner.hasNext()) {
                flagInput = false
                input = scanner.nextLine().trim()
                if(input == "") {
                    flagInput = true
                }
            } else {
                ui.UIError("Пустой ввод, заполните поле снова")
            }
        }
        //scanner.close()
        return input
    }

    // метод ввода пункта меню
    internal fun inputMenu(size: Int): Int {
        val scanner = Scanner(System.`in`)
        var input = -1
        try {
            input = scanner.nextInt()
            if ((input !in 0..size) && (size > 0)) {
                input = -1
                ui.UIError("Некорректный ввод, необходимо выбрать номер пункта меню, заполните поле снова")
            }
        } catch (e: java.lang.Exception) {
            ui.UIError("Некорректный ввод, необходимо ввести число, заполните поле снова")
        }
        //scanner.close()
        return input
    }

    // метод ввода названия группы
    internal fun inputGroup(groups: MutableList<Group>): String {
        ui.UIMessage("Введите название архива:\n")
        var flag = true
        var name = ""
        do {
            flag = false
            name = input()
            for (grp: Group in groups) {
                if (name == grp.name) {
                    flag = true
                    ui.UIError("С таким название архив существует, повторите ввод")
                }
            }
        } while (flag)
        return name
    }

    // метод вывода списка групп на экран
    internal fun outputGroup(groups: MutableList<Group>) {
        ui.UIGroupHeader()
        for (grp: Group in groups) ui.UIGroupPartOne(grp.id, grp.name)
        ui.UIGroupPartTwo(groups.size)
    }

    // метод вывода списка заметок одной группы (архива) на экран
    internal fun outputNotesGroup(group: Group, notes: MutableList<Note>, db: DataBaseHelper) {
        ui.UINotesGroupHeader(group)
        var number = 0
        db.clearMaskNotes()
        for (note: Note in notes) {
            db.addMaskNotes(number, note.id)
            ui.UIGroupNotePartOne(number, note.id, note.name, note.description, note.date)
            number++
        }
        ui.UIGroupNotePartTwo(notes.size)
    }

    // метод ввода сущности блокнота
    internal fun inputNote(group: Group): Note {
        ui.UIMessage("Введите название заметки:\n")
        val name = input()
        ui.UIMessage("Введите описание заметки:\n")
        val description = input()
        val date = SimpleDateFormat("dd-MM-yyyy hh:mm:ss").format(Date())
        val note = Note(id, group.id, group.name, name, description, date)
        id++
        return note
    }

    // метод обновления данных сущности блокнота
    internal fun inputUpdateNote(note: Note): Note {
        ui.UIMessage("Введите название заметки:\n")
        val name = input()
        ui.UIMessage("Введите описание заметки:\n")
        val description = input()
        val date = SimpleDateFormat("dd-MM-yyyy hh:mm:ss").format(Date())
        return Note(note.id, note.idGroup, note.group, name, description, date)
    }

    // метод вывода одной заметки на экран
    internal fun outputNote(note: Note) {
        ui.UINote(note.id, note.group, note.name, note.description, note.date)
    }
}