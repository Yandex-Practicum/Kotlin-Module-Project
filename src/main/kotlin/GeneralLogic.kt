import java.util.Scanner
object GeneralLogic{
    val archiveList : MutableList<NotesArchive> = mutableListOf()
    var appLevel = "MAIN"  // "ARCHIVE" "NOTE"
    var  choiceArchive: NotesArchive? = null
    var  choiceNote: Note? = null
    var value: Boolean = false

    fun choiceCommand(){
        when (appLevel){
            "MAIN" -> {
                println("Вы в главном меню")
                println("Выберите команду, надо написать число:")
                println("0 - Выход\n1 - Создать Архив\n2 - Показать список созданных Архивов")
                this.command()
            }
            "ARCHIVE" -> {
                println("Вы в архиве \'${choiceArchive!!.name}\'")
                println("Выберите команду, надо написать число:")
                println("0 - Выход\n1 - Создать Заметку\n2 - Показать список созданных Заметок")
                this.command()
            }
            "NOTE" -> {
                println("Вы в заметках архива \'${choiceArchive!!.name}\'")
                println("Выберите команду, надо написать число:")
                println("0 - Выход\n1 - Выбрать Заметку")
                var command = readInt(1,::choiceCommand)
                when (command){
                    0 -> exit()
                    1 -> {
                        println("------------")
                        println("Выберите Заметку из списка")
                        choiceArchive!!.noteList.forEachIndexed { index, obj ->
                            println("$index - ${obj.name}")
                        }
                        open(readInt(choiceArchive!!.noteList.size,::choiceCommand))
                    }
                }
            }
        }
    }
    fun command(){
        var command = readInt(2,::command)
        when (command){
            0 -> exit()
            1 -> createArchiveOrNote()
            2 ->  showList()
        }
    }
    fun exit(){
        when (appLevel){
            "NOTE" -> {
                appLevel = "ARCHIVE"
                choiceCommand()
            }
            "ARCHIVE" -> {
                appLevel = "MAIN"
                choiceNote = null
                choiceCommand()
            }
            "MAIN" -> {
                println("Завершение программы")
                choiceArchive = null
                archiveList.clear()
                value = true
            }
        }
    }

    fun createArchiveOrNote(){
        when (appLevel) {
            "MAIN" -> {
                println("Введите имя архива:")
                var probableArchive = Scanner(System.`in`).nextLine()

                if (probableArchive.trim().isNotEmpty()) {
                    archiveList.add(NotesArchive(probableArchive))
                    println("Архив добавлен в список ваших архивов")
                    println("------------")
                    appLevel ="MAIN"
                    choiceCommand()
                } else {
                    println("Имя архива не может быть пустым")
                    this.createArchiveOrNote()
                }
            }
            "ARCHIVE" -> {
                println("Введите имя заметки:")
                var probableNote = Scanner(System.`in`).nextLine()
                if (probableNote.trim().isNotEmpty()) {
                    println("Напишите содержание заметки:")
                    var content: String = Scanner(System.`in`).nextLine()
                    if (content.trim().isNotEmpty()){
                        choiceArchive!!.noteList.add(Note(probableNote, content))
                        println("Заметка успешно сохранена")
                        println("------------")
                        this.choiceCommand()
                    }
                    else {
                        println("Заметка не может быть пустой!")
                        this.createArchiveOrNote()
                    }
                }
                else{
                    println("Имя заметки не может быть пустым!")
                    this.createArchiveOrNote()
                }
            }
        }
    }

    fun showList(){
        when (appLevel){
             "MAIN" -> {
                println("Список созданных архивов:")
                if (archiveList.size == 0) {
                    println("Здесь пусто. Создайте архив")
                    println("------------")
                    this.choiceCommand()
                }
                archiveList.forEachIndexed { index, obj ->
                    println("$index -  ${obj.name}")
                }
                 println("------------")
                 println("Введите число, чтобы выбрать нужный Архив")
                 this.open(readInt(archiveList.size,::showList))
            }
            "ARCHIVE" -> {
                println("Список созданных заметок:")
                if (choiceArchive!!.noteList.size == 0) {
                    println("Здесь пусто. Создайте заметку")
                    println("------------")
                    this.choiceCommand()
                }
                choiceArchive!!.noteList.forEachIndexed { index, obj ->
                    println("$index - ${obj.name}")
                }
                appLevel = "NOTE"
                println("------------")
                choiceCommand()
            }
        }
    }

    fun open(number: Int){
        when (appLevel) {
            "MAIN" -> {
                println("------------")
                choiceArchive = archiveList[number]
                appLevel = "ARCHIVE"
                this.choiceCommand()
            }
            "NOTE" -> {
                println("------------")
                choiceNote = choiceArchive!!.noteList[number]
                println("Вы открыли заметку \"${choiceNote!!.name}\"! Хотите узнать ее содержимое?\n0 - ДА\n1 - НЕТ")
                var answer = readInt(1){open(number)}
                if (answer == 0) {
                    println("---СОДЕРЖАНИЕ---")
                    choiceNote!!.knowContent()
                    println("------------")
                    this.choiceCommand()
                }
                else if (answer==1){
                    appLevel = "ARCHIVE"
                    this.choiceCommand()
                }
            }
        }
    }

    fun readInt(max: Int = Int.MAX_VALUE, onError: () -> Unit): Int {
        while (true) {
            val input = readLine()
            val number = input?.toIntOrNull()

            if (number == null) {
                println("Введите число, а не что-то другое")
                onError()
            } else if (number < 0 || number > max) {
                // Проверяем что >= 0 и <= max
                println("Нет команды под таким числом")
                onError()
            } else {
                return number
            }
        }
    }
}