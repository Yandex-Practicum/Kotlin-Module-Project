import java.util.*

fun screen4(archiveNumLocal:Int){
    println("Архив: ${listOfArchives[archiveNumLocal-2]}")
    println("СОЗДАНИЕ ЗАМЕТКИ\n Для выхода введите \"в1\"\n Введите название заметки:")
    val sc1 = Scanner(System.`in`).nextLine()
    println(" Введите содержание заметки:")
    val sc2 = Scanner(System.`in`).nextLine()
    if (sc1.lowercase() != "в1" && (sc2.lowercase() != "в1")) {
        listOfListOfNotes[archiveNumLocal-2].add(sc1)
        listOfListOfContents[archiveNumLocal-2].add(sc2)
    }
}
