open class RepeatedFunctions{
    fun createNew(index: Int?, isNote: Boolean, messages: List<String>) {
        println(messages[0])
        val name = sc.nextLine()
        val names = if(isNote) archives[index!!].archiveData.map { element -> element.noteName } else archives.map{element -> element.archiveName}
        if (names.contains(name)) {
            println(messages[1])
            createNew(index, isNote, messages)
        }
        if (isNote) {
            println("Введите текст заметки")
            val text = sc.nextLine()
            archives[index!!].archiveData.add(Note(name, text))
            println("Заметка успешно создана!")
            dm.askAction(index)
        } else {
            archives.add(Archive(name))
            println("Архив $name был успешно создан")
            start(true)
        }
    }

    fun read(index: Int?, isNote: Boolean, message: String){
        println(message)
        val list = if(isNote) archives[index!!].archiveData else archives
        if(list.isEmpty()) {
            if(isNote){
                println("У вас нет заметок!")
                dm.askAction(index!!)
            } else {
                println("У вас нет архивов!")
                start(true)
            }
        }
        list.forEach{element -> if(element is Note) println(element.noteName) else if(element is Archive) println(element.archiveName) else println("You broke my code!") }
        val response = sc.nextLine()
        val names = list.map{element -> if(element is Note) element.noteName else if(element is Archive) element.archiveName else "An error occurred"}
        if(names.contains(response)){
            val obj = list[names.indexOf(response)]
            if(obj is Note){
                println("Название заметки: ${obj.noteName} \nТекст: ${obj.noteText}")
                dm.askAction(index!!)
            }
            else if(obj is Archive){
                dm.askAction(names.indexOf(obj.archiveName))
            }

        } else{
            println("Не найдено элемента с таким названием! Пожалуйста, попробуйте снова.")
            rf.read(index, isNote, message)
        }
    }
}