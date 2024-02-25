class Archive(override val name: String) : Parent, Sample() {

    override val word = "note"
    override val exit = "Вернуться назад"

    override fun makeInstance(name: String, text: String) {
        val note = Note(name, text)
        map[counter.toString()] = note
    }
}