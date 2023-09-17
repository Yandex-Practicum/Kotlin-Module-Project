class Note(val title: String, val content: String) {

    override fun toString(): String {
        return title
    }

    fun showTheNote(): String {
        return "\n$DIVIDER\nЗАГОЛОВОК: $title\nСОДЕРЖАНИЕ: $content\n$DIVIDER\n"
    }

    companion object {
        private const val DIVIDER = "--------------------------------------------"

    }

}