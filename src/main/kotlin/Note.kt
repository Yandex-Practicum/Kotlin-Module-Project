import java.sql.DriverManager.println

data class Note (val textNote: String) {
    override fun toString(): String {
        return textNote
    }

    fun printNote ()  {
        println("Текст заметки: $textNote")
    }
}