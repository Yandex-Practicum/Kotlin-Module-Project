class NotesArchivesMenu(var notes: MutableMap<String, MutableList<String>>) {


    fun showNotesArchivesMenu(): Triple<Any, String, Boolean> {
        val menu = Menu()
        return menu.choiceMenu(this,"notes")
    }

    fun createNotesArchives() {
        // Логика для создания архива
        var flag = false
        while(!flag) {
            print("Введите название заметки: ")
            val input = readLine()
            if (!input.equals("")){
                notes[input.toString()] = mutableListOf<String>()
                    flag = true
            }
            else{
                println("Поле не может быть пустым")
            }
        }
    }

}
