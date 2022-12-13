class DataManager: RepeatedFunctions() {

    fun askAction(index: Int){
        val workWith = archives.get(index)
            println("Что вы хотите сделать с архивом ${workWith.archiveName}?\n0. Создать в нем новую заметку\n1. Прочитать заметку\nЛюбой иной вариант - Назад")
        when(sc.nextLine()){
            "0" -> rf.createNew(index, true, mutableListOf("Введите название заметки", "Заметка с таким именем уже существует!"))
            "1" -> if(workWith.archiveData.isNotEmpty()) rf.read(index, true, "Выберите заметку:") else {
                println("В этом архиве пока нет заметок для прочтения!")
                askAction(index)
            }
            else -> start(true)
        }

    }
}