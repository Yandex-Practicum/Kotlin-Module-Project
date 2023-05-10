import java.util.*

class Archive(val nameArchive: String) {
    val notes: MutableList<Note> = mutableListOf()

    companion object {
        fun create(): Archive {
            println("Давайте создадим архив\nВведи имя архива!")
            val name = Scanner(System.`in`).nextLine()
            val archive = Archive(name)
            println("Создан архив: ${archive.nameArchive}")
            return archive

        }
    }

}



