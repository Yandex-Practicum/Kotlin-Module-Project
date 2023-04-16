import java.util.Scanner

class MapNotes (val keyNote: String, val note: String) {
    val mapNotes: MutableMap<String, String> = mutableMapOf()

    //Создаем тестовые заметки и архивы
    // val mapNotes  = mutableMapOf("Заметка #1" to "Значение заметки #1",
    //     "Заметка #2" to "Значение заметки #2","Заметка #3" to "Значение заметки #3",)
    fun addMapNotes(
        mapNotes: MutableMap<String, String>,
        keyNote: String,
        note: String
    ): MutableMap<String, String> {
        mapNotes.plusAssign(keyNote to note)
        return mapNotes
    }

    fun makeNote() {
        val input = Scanner(System.`in`)
        println("Введите название заметки")
        val keyNote = (input.nextLine())
        println("Введите содержание заметки")
        val note = (input.nextLine())
        addMapNotes(mapNotes, keyNote, note)
        println("Заметка добавлена")
        val countmapNotes = mapNotes.size
        println("Теперь заметок стало $countmapNotes")
    }
}


class MapArhiv (val keyArhiv:String, val arhiv: MapNotes) {

    //make arhive
    val mapArhiv : MutableMap<String,MapNotes> = mutableMapOf ()

    fun addToArhiv (keyArhiv:String, arhiv: MapNotes) {
        mapArhiv.plusAssign (keyArhiv to arhiv)
    }

    fun makeArhiv() {
        val input = Scanner(System.`in`)
        println("Введите название архива")
        val keyArhiv = (input.nextLine())

        addToArhiv (keyArhiv, arhiv)
        println("Архив создан")
        val countmapArhives = mapArhiv.size
        println("Теперь количество архивов стало $countmapArhives")
    }


}