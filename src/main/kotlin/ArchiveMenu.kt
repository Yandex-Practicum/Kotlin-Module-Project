object ArchiveMenu {
    val archives = mutableListOf<Archive>()

    fun createArchive(menu : Menu){
        println("Введите название ")
        val name = menu.readText()
        archives.add(Archive(name))
        menu.end()

    }
    fun show(){
        while (true){
            val menu = Menu("Архивы")
            menu.addItem("Создать архив"){
                createArchive(menu)
            }
            archives.forEach { archive -> menu.addItem(archive.name) {NoteMenu.show(archive)} }

            menu.addItem("Выход из программы"){
                println("Программа завершена.")
                System.exit(0)            }
            menu.show()



        }
    }



}