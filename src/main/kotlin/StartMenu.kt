class StartMenu : Sample() {

    override val word = "archive"
    override val exit = "Выход"
    override fun makeInstance(name: String, text: String) {
        val archive = Archive(name)
        map[counter.toString()] = archive
    }

    override fun makeText(): String {
        return ""
    }
}



