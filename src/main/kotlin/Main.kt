fun main() {
    // ваш код начнется здесь
    // вы не должны ограничиваться только классом Main и можете создавать свои классы по необходимости

    var action = Screen.ARCHIVES
    var archiveList: MutableList<Archive> = ArrayList() // список архивов
    var noteList: MutableList<Note> = ArrayList() // список заметок, которые не прикреплены к архиву
    var currentArchiveName: String = ""

    while (action != Screen.EXIT) {

        var choiceMap: MutableMap<Int, String> = mutableMapOf() // список меню для экранов

        when (action) {
            Screen.ARCHIVES -> choiceMap = viewArchiveMenu(archiveList)
            Screen.NOTES -> choiceMap = viewNotesMenu()
            Screen.CREATE_ARCHIVE -> {
                val archive: Archive = createArchive()
                archiveList.add(archive)
                choiceMap = viewArchiveMenu(archiveList)
                action = Screen.ARCHIVES
            }
            Screen.CREATE_NOTE -> {
                val note: Note = createNote()
                noteList.add(note)
                choiceMap - viewNotesMenu()
                action = Screen.NOTES
            }
            else -> throw IllegalStateException("Нет такой команды")
        }

        // читаем ответ пользователя
        val input = readLine()

        // делаем проверки
        when {
            input == null -> println("Упс. Что-то пошло не так. Попробуйте еще раз.")
            input.isEmpty() -> println("Ничего не введено. Попробуйте еще раз.")
            else -> {
                val number = input.toIntOrNull()
                if (number == null) {
                    println("Вы не ввели цифру. Повторите, пожалуйста, ввод.")
                } else {
                    if (choiceMap[number] != null) {
                        when (action) {
                            Screen.ARCHIVES -> action = checkArchiveAnswer(number)
                            Screen.NOTES -> action = checkNotesAnswer(number)

                            else -> throw IllegalStateException("Нет такой команды")
                        }
                    }
                    else {
                        println("Такой цифры нет. Пожалуйста, выберете из списка.")
                    }
                }
            }
        }
    }
    println("Finish")
}


