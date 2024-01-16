data class Note(val name: String, var text: String) {

    fun addTextToNote(addText: String) {
        this.text.plus(" $addText")
    }
    fun showNote(){
        println("\n=====\n Имя:${this.name} \nСодержимое:${this.text}")
    }
}