data class Archive(val archName: String, val content: MutableList<Note>){
    override fun toString(): String {
        return archName
    }
}
