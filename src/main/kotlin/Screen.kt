class Screen {
    fun start(){
        val setOfArch: MutableSet<Folder> = mutableSetOf()
        createScreen(setOfArch, Archive(), "")

    }
private fun createScreen(set:MutableSet<Folder>, folder: Folder, parentName: String){
    do {
        val menuList:MutableList<String> = mutableListOf()
        println("Вы находитесь в меню ${folder.caseName} $parentName")
        menuList.add("Создать ${folder.itemsName}")
       if (set.isNotEmpty()) set.forEach{menuList.add(it.name) }
        menuList.add(folder.exitName)
        println("Выберите пункт меню (целое число):\nСписок ${folder.caseName}:")
    menuList.forEachIndexed {i, it -> println("${i}. $it")}
    val command: Int = handlingInput(readln(), menuList.size)
    when (command) {
        0 -> {
            val input = nameSet(folder.correctName)
            if (!menuList.contains(input)) {
                set.add(itemAdd(folder, input))
                println("Успешно добавлено!\n")
            } else println("Такое ${folder.correctName} уже существует!")
        }

        in 1..menuList.size - 2 -> {
            val element: Folder = set.elementAt(command - 1)
            element.command()
        }

}
}while (command != menuList.size - 1)
}
    private fun itemAdd(folder: Folder, input: String): Folder {
        val result = folder.instanceGet(input)
        if (result is Note) result.content = nameSet("текст заметки")
        return result
    }
    private fun handlingInput(input: String, menuSize: Int): Int {
        var command: Int = -1
        try {
            command = input.toInt()
            if (command !in 0 until menuSize) {
                println("Такого пункта меню нет!")
                command = -1
            }
        } catch (e: NumberFormatException) {
            println("Неправильный ввод!")
        }
        return command
    }
    private fun nameSet(case:String):String{
        var input:String
        do {
            println("Введите $case")
            input = readln()
            if (input.isEmpty())
                println("${case.replaceFirstChar { case[0].uppercase() }} не может быть пустым!")
        } while (input.isEmpty())
        return input
    }
    private fun Folder.instanceGet(name:String):Folder{
        return when (this){
            is Archive -> Archive(name)
            else -> Note(name)
        }
    }
    private fun Folder.command() {
        when (this){
            is Archive -> createScreen(this.noteSet,Note(),"архива \""+this.name+"\"")
            is Note -> println("\nСодержание заметки\"${this.name}\":\n${this.content}\n")
        }
    }
}

