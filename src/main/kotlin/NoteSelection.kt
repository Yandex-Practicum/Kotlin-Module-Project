class NoteSelection() : MenuClass() {
    var noteCreate = MenuClass("--------------------\n" +
            "СОЗДАНИЕ ЗАМЕТКИ\n" +
            "Введите содержимое заметки либо 0 - для выхода\n")
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
        var command = ""
        var num = menuCommandMap.size // число пунктов меню
        while(true) {
            noteCreate.printMenu()
            command = noteCreate.getUserCommand()
            when (command) {
                "O" -> break // when
                "" -> {
                    println("Ошибка: сожержимое заметки не может быть пустым. Попробуйте еще раз!")
                    continue
                }//""
                else -> {
                    var note = Note(command)
                    noteList.add(note)
                    menuCommandMap.put(num, {
                        note.printContent()
                        true
                    })
                    break
                }
            }
        }//while*/
    } //fun addArchive
}