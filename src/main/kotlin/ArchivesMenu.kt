class ArchivesMenu (var archives: MutableMap<String, MutableMap<String, MutableList<String>>>){
    fun showArchivesMenu(): Triple<Any, String, Boolean> {
        val menu = Menu()
        return menu.choiceMenu(this, "archives")
    }
    fun createArchive() {
        // Логика для создания архива
        var flag = false
        while(!flag){
            print("Введите название архива: ")
            val input = readLine()
            if (!input.equals("")){
                archives[input.toString()] = mutableMapOf ()
                flag = true
            }
            else{
                println("Поле не может быть пустым")
            }
        }
    }

}