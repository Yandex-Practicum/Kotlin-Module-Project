import java.util.*

fun screen2() {
    println("Создание архива заметок.\n Для выхода введите \"в1\"\n Введите название архива:")
    val sc = Scanner(System.`in`).nextLine()
    if (sc.lowercase() != "в1") {
        archives[sc] = mutableMapOf()
        listOfArchives.add(sc)
        listOfListOfNotes.add(mutableListOf())
        listOfListOfContents.add(mutableListOf())
    }
}