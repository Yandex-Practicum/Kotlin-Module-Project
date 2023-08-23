class Archive(val name: String)  {

    companion object {
        var archives : MutableList<Archive> = mutableListOf()

        fun howMuch() {
            println("В списке ${archives.size} архивов")
        }
    }
    var notes : MutableList<Note> = mutableListOf()





}
