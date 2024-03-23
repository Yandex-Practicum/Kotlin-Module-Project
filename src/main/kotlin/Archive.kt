class Archive (val name: String){
    fun doNoteSelection(){
        val noteSelection = NoteSelection()
        var command = ""
        var result: Boolean

        while(true){
            noteSelection.printMenu()
            command = noteSelection.getUserCommand()

            if(!isInt(command)) {
                println("Ошибка: надо ввести целое число!")
                continue
            }
            if(command.toInt() > (noteSelection.menuCommandMap.size - 1)) {
                println("Ошибка: такого пункта меню нет. Попробуйте еще раз!")
                continue
            }
            if(command.toInt() <0) {
                println("Ошибка: число должно быть целым положительным, ведь это номер пункта меню!")
                continue
            }
            result = noteSelection.menuCommandMap[command.toInt()]!!.invoke()
            when (result) {
                true -> continue
                false -> break
            }
        }
    }
}