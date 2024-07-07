class Note (var name : String)  {
    private var arr : MutableList<String> = mutableListOf()

    private fun printMenu(){
        println("Закладка: ${this.name}")
        println("0.Выйти из закладки")
        println("1.Просмотр закладки")
        println("2.Переиминовать закладку")
        println("3.Обновить/Записать текст в закладку")
        println("4.Удалить закладку")
    }

    fun menu (
        scanner :GeneralScanner,
        deleteUp:(note:Note)->Unit
              ){
        printMenu()
        var inpu : Int  = -1
        while(true) {
            scanner.takeInt { it -> inpu = it}
            when (inpu) {
                0 -> return
                1 -> viewingNote()
                2 -> updatingNameNote(scanner)
                3 -> updatingTextNote(scanner)
                4 -> {deleteThisNote(deleteUp)
                    return}
                else -> println("Невернный ввод")
            }
            printMenu()
        }
    }


    private fun viewingNote(){
        println("Смотрим закладку ${this.name}")
        if(arr.size == 0){
            println("Пусто")
        } else {
            arr.forEach() {
                println(it)
            }
        }
    }

    private fun updatingTextNote(scanner : GeneralScanner){
        scanner.takeText(arr)
    }

    private fun updatingNameNote(scanner :GeneralScanner){
        scanner.takeName { it ->  name = it }
    }

    fun deleteThisNote(
        deleteUpObject:(note:Note)->Unit
    ){
        arr.clear()
        deleteUpObject(this)
    }

}