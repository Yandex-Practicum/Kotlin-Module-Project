data class Note(val name: String, var text: String) {
    fun showNote() {
        println("=====\nИмя:${this.name} \nСодержимое:${this.text}")
    }
}