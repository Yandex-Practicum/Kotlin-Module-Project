package dataClass

data class Archive(
    val name: String,
    val notes: MutableList<Any>) {

    fun createArchiv(): Archive {
            val name = "Name new archiv"
            val note = mutableListOf<Any>()
            val archive = Archive(name, note)
            return archive
    }

}
