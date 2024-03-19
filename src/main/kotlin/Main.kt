import utility.DataBaseHelper
import utility.InputOutputStream
import view.UIView

fun main(args: Array<String>) {
    val ui = UIView()
    val io = InputOutputStream()
    val db = DataBaseHelper()

    var flag = true
    var levelMenu = 0
    var idGroup = -1
    var idNote = -1
    while (flag) { // цикл работы программы
        var stepMenu = -1
        while (stepMenu == -1) { // цикл отрисовки меню и выбора одного из его пунктов
            var number = 0
            when (levelMenu) {
                0 -> { // уровень 0 (стартовая страница)
                    ui.UIStart() // отрисовка
                    number = 3 // количество пунктов меню
                }
                1 -> { // уровень 1 (список архивов)
                    io.outputGroup(db.getGroups())  // отрисовка
                    number = db.getGroups().size // количество пунктов меню
                }
                2 -> { // уровень 2 (список заметок для выбранного архива)
                    io.outputNotesGroup( // отрисовка
                        db.getGroup(idGroup),
                        db.getNotesGroup(idGroup),
                        db
                    )
                    number = db.getNotesGroup(idGroup).size + 1 // количество пунктов меню
                }
                3 -> { // уровень 3 (вывод определённой заметки)
                    io.outputNote(db.getNoteGroup(idNote))  // отрисовка
                    number = 3 // количество пунктов меню
                }
            }
            stepMenu = io.inputMenu(number) // выбор пункта меню
        }

        // обработка данных ввода пользователя
        if (levelMenu == 0) { // уровень 0 (стартовая страница)
            when (stepMenu) {
                0 -> db.addGroup(io.inputGroup(db.getGroups()))
                1 -> levelMenu = 1
                2 -> {
                    ui.UIMessage("Выход из программы")
                    flag = false
                }
                else -> ui.UIError("Некорректный ввод, введите пункт меню снова")
            }
        } else if (levelMenu == 1) {  // уровень 1 (список архивов)
            if (stepMenu < db.getGroups().size) {
                levelMenu = 2
                idGroup = stepMenu // выбор определённого архива
            } else if (stepMenu == db.getGroups().size) { // возврат к кпредыдущему меню
                levelMenu = 0
            } else {
                ui.UIError("Некорректный ввод, введите пункт меню снова")
            }
        } else if (levelMenu == 2) { // уровень 2 (список заметок для выбранного архива)
            if (stepMenu < db.getNotesGroup(idGroup).size) { // просмотр определённой заметки
                levelMenu = 3
                idNote = db.maskToIdNote(stepMenu)
            } else if (stepMenu == db.getNotesGroup(idGroup).size) { // создание новой заметки
                db.addNote(io.inputNote(db.getGroup(idGroup)))
            } else if (stepMenu == (db.getNotesGroup(idGroup).size + 1)) { // возврат к предыдущему меню
                levelMenu = 1
            } else {
                ui.UIError("Некорректный ввод, введите пункт меню снова")
            }
        } else if (levelMenu == 3) { // уровень 3 (просмотр и редактирование заметки)
            when (stepMenu) {
                0 -> { // редактирование заметки
                    db.updateNote(io.inputUpdateNote(db.getNoteGroup(idNote)))
                    levelMenu = 2
                }
                1 -> { // удаление заметки
                    db.deleteNote(db.getNoteGroup(idNote))
                    levelMenu = 2
                }
                2 -> levelMenu = 2
                else -> ui.UIError("Некорректный ввод, введите пункт меню снова")
            }
        }
    }
}