package view

import entity.Group

class UIView {
    private val textHeader = "\u001b[38;2;37;80;89;48;2;142;188;196m\u001B[1m\u001B[3m"
    private val textBody = "\u001b[38;2;37;80;89;48;2;142;188;196m"
    private val textError = "\u001b[38;2;211;101;88m\u001B[3m"
    private val textMessage = "\u001b[38;2;142;188;196m\u001B[3m"
    private val textData = "\u001B[38;2;77;138;79;48;2;142;188;196m"
    private val reset = "\u001b[0m"

    fun UIStart() {
        print("$textHeader\n\tПРИЛОЖЕНИЕ ЗАМЕТКИ\n$reset")
        print("$textBody\t\tМеню:\n\t\t\t0\tСоздать архив\n\t\t\t1\tПросмотр и управление архивами\n\t\t\t2\tВыход из программы\n\n Ввод:\n$reset")
    }

    fun UIError(message: String) {
        println("$textError$message$reset")
    }

    fun UIMessage(message: String) {
        print("$textMessage$message$reset")
    }

    fun UIGroupHeader() {
        print("$textHeader\n\tУПРАВЛЕНИЕ АРХИВАМИ\n$reset")
        print("$textBody\t\tМеню просмотра и редактирования архивов:\n$reset")
    }

    fun UIGroupPartOne(id: Int, name: String) {
        UIMessage("$textBody\t\t\t$id$reset$textData\t\t$name\n$reset")
    }

    fun UIGroupPartTwo(number: Int) {
        UIMessage("$textBody\t\t\tДля возврата в предыдущее меню введите число ${number}\n\nВвод:\n$reset")
    }

    fun UINotesGroupHeader(group: Group) {
        print("$textHeader\n\tУПРАВЛЕНИЕ ЗАМЕТКАМИ\n$reset")
        print("$textBody\t\tМеню просмотра заметок архива: $reset$textData${group.name}\n$reset")
    }

    fun UIGroupNotePartOne(id: Int, idNote: Int, name: String, description: String, date: String) {
        UIMessage("$textBody\t\t\t$id$reset$textData\t\tID-$idNote\t\t$name\t\t$description\t\t$date\n$reset")
    }

    fun UIGroupNotePartTwo(number: Int) {
        UIMessage("$textBody\t\t\tДля создания новой заметки введите число ${number}\n$reset")
        UIMessage("$textBody\t\t\tДля возврата в предыдущее меню введите число ${number + 1}\n\nВвод:\n$reset")
    }

    fun UINote(id: Int, nameGroup: String, name: String, description: String, date: String) {
        print("$textHeader\n\tПРОСМОТР И РЕДАКТИРОВАНИЕ ЗАМЕТКИ\n$reset")
        UIMessage("$textData\tID $id\tАрхив $nameGroup\tНазвание $name\tОписание $description\tДата $date\n$reset")
        print("$textBody\t\tМеню:\n$reset")
        UIMessage("$textBody\t\t\t0\tРедактирование заметки\n\t\t\t1\tУдаление заметки\n$reset")
        UIMessage("$textBody\t\t\t2\tВозврат в предыдущее меню\n\nВвод:\n$reset")
    }
}