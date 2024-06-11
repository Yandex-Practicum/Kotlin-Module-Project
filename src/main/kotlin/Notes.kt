class Notes(var notes: MutableList<String>) {
    private val menu: Menu = Menu()
    fun showNotesMenu():Any{
        while (true) {
            if (notes.isEmpty())
                println("Ваша заметка пуста")
            else {
                println("Ваша заметка:")
                showNotes()
            }
            println("Меню:\n 0- Выход")
            if(notes.isEmpty()){
                println("1- Заполнить заметку")
            }
            else println("1- Изменить текст заметки")
            println("2- Удалить текст заметки")

            when (menu.getUserChoice(2)) {
                0 -> {
                    println("Возвращаюсь...")
                    break
                }
                1 -> {
                    if(notes.isEmpty())
                        createNotes()
                    else changeNotes()
                }
                2 -> deleteNotes()
                else -> {
                    println("Такого пункта нет. Попробуйте снова.")
                }
            }

        }
        return notes
    }

    private fun showNotes(){
        println(notes)
    }
    private fun createNotes(){
        var flag = false
        while(!flag){
            print("Введите заметку:")
            var input = readLine()
            if (!input.equals("")){
                notes = listOf(input) as MutableList<String>
                flag = true
            }
            else{
                println("Поле не может быть пустым")
            }
        }


    }
    private fun changeNotes(){
        println("Ваша заметка:")
        showNotes()
        println("Введите измененную заметку:")
        createNotes()
    }
    private fun deleteNotes(){
        notes = mutableListOf<String>()
    }

}