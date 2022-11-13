class Archives (val name: String): GivingName {
    val note = mutableListOf<Note>()
    override fun giveName(): String {
        return name
    }
}