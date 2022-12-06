class DataManager {
    var archives: MutableList<Archive> = mutableListOf()
    fun createArchive(){
        println("Введите название для нового архива")
        val name: String = sc.nextLine()
        if(archives.map{element -> element.archiveName}.contains(name)) {
            println("Архив с таким именем уже существует!")
            dm.createArchive()
        }
        archives.add(Archive(name))
        println("Архив $name был успешно создан")
        start(true)
    }
    fun manageArchives(){
        if(archives.isNotEmpty()) {
            println("Ваши архивы:")
            for(a in archives){
                println(a.archiveName)
            }
            println("Введите имя архива, который хотите использовать:")
            val choice = sc.nextLine()
            val names = archives.map{element -> element.archiveName}
            if(names.contains(choice)){
                askAction(names.indexOf(choice))
            } else {
                println("Не найдено архива с таким именем! Проверьте правильность своего ввода и попробуйте снова")
                manageArchives()
            }
        } else {
            println("У вас нет архивов! Вы можете создать новый в меню:")
        }
        start(true)
    }

    fun askAction(index: Int){
        val workWith = archives.get(index)
            println("Что вы хотите сделать с архивом ${workWith.archiveName}?\n0. Создать в нем новую заметку\n1.Прочитать заметку\nЛюбой иной вариант - Назад")
        when(sc.nextLine()){
            "0" -> workWith.newNote(index)
            "1" -> if(workWith.archiveData.isNotEmpty()) workWith.readNote(index) else {
                println("В этом архиве пока нет заметок для прочтения!")
                askAction(index)
            }
            else -> return
        }

    }
}