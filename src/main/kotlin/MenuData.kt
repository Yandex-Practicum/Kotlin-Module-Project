data class MenuData(val name: String, val action: () -> Boolean) {
    override fun toString(): String {
        return name
    }
}