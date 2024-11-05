import java.util.Date

class Note(
    private val name: String,
    private val text: String
) {
    private val dateCreated: Date = Date()

    public fun getName(): String{
        return this.name
    }

    public fun readTextNote(){
        println("Название: $name\nДата создания: $dateCreated\n$text")
    }

}