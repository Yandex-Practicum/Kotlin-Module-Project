class ArchiveSelection: MenuClass() {
    var archiveCreate = MenuClass("--------------------\n" +
            "СОЗДАНИЕ АРХИВА\n" +
            "Введите название архива либо 0 - для выхода\n ")
    var archiveList = mutableListOf<Archive>()
    var menuCommandMap = mutableMapOf<Int,()->Boolean>()
    init {
        menuText = "--------------------\n" +
                "ВЫБОР АРХИВА\n" +
                "Введите:\n" +
                "0 - для выхода\n" +
                "1 - для создания архива\n"

        menuCommandMap.put(0, {false})
        menuCommandMap.put(1, {
            addArchive() // окно СОЗДАНИЕ АРХИВА
            true
        })
    }
    override fun printMenu() {
        print(menuText)
        if (menuCommandMap.size > 2) {
            println("либо номер нужного архива:")
            for (i in 0..archiveList.size-1) {
                println("${i+2} - ${archiveList[i].name}")
            }
        }
    }
    fun addArchive(){
        var command = ""
       var num = menuCommandMap.size // число пунктов меню
        while(true) {
            archiveCreate.printMenu()
            command = archiveCreate.getUserCommand()
        when (command) {
                "O" -> break // when
                "" -> {
                    println("Ошибка: название архива не может быть пустым. Попробуйте еще раз!")
                    continue
                }//""
                else -> {
                    if (containsArchive(command)){
                        println("Архив с таким названием уже существует. Попробуйте еще раз!")
                        continue
                    } else {
                         var archive = Archive(command)
                        archiveList.add(archive)
                        menuCommandMap.put(num, {
                            archive.doNoteSelection()
                            true
                        })
                        break
                    }//else
                }
            }
        }//while
    } //fun addArchive

    private fun containsArchive(s: String): Boolean{
        /*for(archive in archiveList){
            if (archive.name == s)
                return true
        }*/
        archiveList.find {it.name == s}
        return false
    }
}