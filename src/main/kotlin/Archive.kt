class Archive(var name : String ) {
    private var arr : MutableList<Note> = mutableListOf()


    private fun printMenu(){
        println("Архив: ${this.name}")
        println("0.Выйти из архива")
        println("1.Переиминовать архив")
        println("2.Посмотреть закладки")
        println("3.Перейти в закладку")
        println("4.Добавить новую закладку")
        println("5.Удалить архив")
    }

    fun menu (
        scanner :GeneralScanner,
        ondelet: (arr:Archive)->Unit
    ){
        printMenu()
        var inpu : Int  = -1
        while(true) {
            scanner.takeInt { it -> inpu = it}
            when (inpu) {
                0 -> return
                1-> addNewName(scanner)
                2 -> {
                    println("Смотрим закладки")
                    viewingAllNote()
                }
                3 -> choiceNote(scanner)
                4 -> addNewNote(scanner)
                5 -> {
                    delete(ondelet)
                    return
                }
                else -> println("Невернный ввод")
            }
            printMenu()
        }
    }
    
    private fun viewingAllNote(){
        var i = 1
        if(arr.size == 0){
            println("Пусто")
        } else {
            arr.forEach() {
                println(i.toString()+ ". " + it.name)
                i++
            }
        }
    }

    private fun addNewNote(scanner :GeneralScanner){
        scanner.takeName { it -> arr.add(Note(it)) }
    }

    private fun addNewName(scanner :GeneralScanner){
        scanner.takeName { it ->  name = it }
    }

    private fun choiceNote(scanner :GeneralScanner){
        println("Выберите архив")
        var inpu : Int  = -1
        println("0. Вернутся назад")
        viewingAllNote()
        while(true){
            scanner.takeInt { it -> inpu = it}
            if(inpu == 0 ) {
                return
            } else {
                if (inpu >= 1 && inpu <= arr.size) {
                    arr[inpu-1].menu(scanner,{it ->deleteNote(it)})
                    return
                }else {
                    println("Неверный ввод")
                }
            }
        }
    }

    private fun delete(ondelete:(arr:Archive)->Unit){
        arr.forEach(){
            it.deleteThisNote( { it -> deleteNote(it) })
        }
        ondelete(this)
        return
    }

    private fun deleteNote(me : Note){
        arr.remove(me)
    }

}