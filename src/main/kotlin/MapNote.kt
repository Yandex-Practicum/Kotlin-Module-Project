import java.util.Scanner

class MapNotes (val mutableMapNotes: MutableMap<String, String>) {


    //Создаем тестовые заметки и архивы
    // val mapNotes  = mutableMapOf("Заметка #1" to "Значение заметки #1",
    //     "Заметка #2" to "Значение заметки #2","Заметка #3" to "Значение заметки #3",)
    private fun addMapNotes(
        mapNotes: MapNotes,
        keyNote: String,
        note: String
    ): MutableMap<String, String> {
        mapNotes.mutableMapNotes.plusAssign(keyNote to note)
        return mapNotes.mutableMapNotes
    }

    fun makeNote(mapNotes: MapNotes) {
        val input = Scanner(System.`in`)
        println("Введите название заметки")
        val keyNote = (input.nextLine())
        println("Введите содержание заметки")
        val note = (input.nextLine())
        addMapNotes(mapNotes, keyNote, note)
        println("Заметка добавлена")
        val countmapNotes = mapNotes.mutableMapNotes.size
        println("Теперь заметок: $countmapNotes")
    }
}


class MapArhiv (val mapArhiv : MutableMap<String,MapNotes>) {

    //make arhive


    private fun addMapNoteToArhiv (keyArhiv:String) {
        val mapNotesInArhiv = MapNotes( mutableMapOf())
        mapArhiv.plusAssign (keyArhiv to mapNotesInArhiv)
    }

    fun makeArhiv() {
        val input = Scanner(System.`in`)
        println("Введите название архива")
        val keyArhiv = (input.nextLine())
        //val mapNotes: MutableMap<String, String> = mutableMapOf()

        addMapNoteToArhiv (keyArhiv)
        println("Архив создан")
        val countmapArhives = mapArhiv.size
        println("Теперь количество архивов стало $countmapArhives")
    }

}