class Note(val name: String, val text: String) {
    override fun toString(): String {
        return " \tИмя заметки- \" $name \"\n \tТекст заметки-$text"
    }
}
