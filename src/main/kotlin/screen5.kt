import java.util.*

fun screen5(answerConverted:Int){
    println("Содержание заметки ${listOfListOfNotes[archiveNum-2][answerConverted-2].uppercase()}:\n\n ${listOfListOfContents[archiveNum-2][answerConverted-2]}\n")
    println("Если вы уже начитались, то для выхода введите \"1\"")
    val sc = Scanner(System.`in`).nextLine()
    if (sc.lowercase() != "1") {
        return
    }

}