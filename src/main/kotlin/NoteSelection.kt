class NoteSelection() : MenuClass() {
    var noteCreate = MenuClass("--------------------\n" +
            "СОЗДАНИЕ ЗАМЕТКИ\n" +
            "Введите название заметки либо 0 - для выхода\n")
    var noteList = mutableListOf<Note>()
    var menuCommandMap = mutableMapOf<Int,()->Boolean>()
    init {
        menuText = "--------------------\n" +
                "ВЫБОР ЗАМЕТКИ\n" +
                "Введите:\n" +
                "0 - для выхода\n" +
                "1 - для создания заметки\n"

        menuCommandMap.put(0, {false})
        menuCommandMap.put(1, {
            addNode() // окно СОЗДАНИЕ ЗАМЕТКИ
            true
        })
    }
    override fun printMenu() {
        print(menuText)
        if (menuCommandMap.size > 2) {
            println("либо номер нужной заметки:")
            for (i in 0..noteList.size-1) {
                println("${i+2} - ${noteList[i].name}")
            }
        }
    }
    fun addNode(){
        var commandName = ""
        var num = menuCommandMap.size // число пунктов меню
        while(true) {
            noteCreate.printMenu()
            commandName = noteCreate.getUserCommand()
            when (commandName) {
                "0" -> break // when
                "" -> {
                    println("Ошибка: название заметки не может быть пустым. Попробуйте еще раз!")
                    continue
                }//""
                else -> {
                    var noteContent = MenuClass("--------------------\n" +
                           "Введите содержимое заметки либо 0 - для выхода\n")
                    var commandContent =""
                    while(true){
                        noteContent.printMenu()
                        commandContent = noteContent.getUserCommand()
                        when(commandContent){
                            "0" -> {
                                println("Заметка не была создана!")
                                break
                            } // when
                            "" -> {
                                println("Ошибка: cодержимое заметки не может быть пустым. Попробуйте еще раз!")
                                continue
                            }//""
                            else -> {
                                var note = Note(commandName, commandContent)
                                noteList.add(note)
                                menuCommandMap.put(num, {
                                    note.printContent()
                                    true
                                })
                                break
                            }
                        }
                    }
                    break
                }
            }
        }//while*/
    } //fun addArchive
}