import java.util.Scanner

fun main() {

    val archive = Archive()

    var keyLevel1 = ""
    var keyLevel2 = ""
    var level = "archives"
    while (true) {
        if (level == "archives") {
            archive.showList()
            level = archive.inputHandler(getInput())
            level = when(level) {
                "this" -> "archives"
                "the_end" -> break
                else -> { keyLevel1 = level; "notes" }
            }
        }
        if (level == "notes") {
            archive.list.getValue(keyLevel1).showList()
            level = archive.list.getValue(keyLevel1).inputHandler(getInput())
            level = when(level) {
                "this" -> "notes"
                "the_end" -> "archives"
                else -> { keyLevel2 = level; "reading" }
            }
        }
        if (level == "reading") {
            println("\n-> ${archive.list.getValue(keyLevel1).list.getValue(keyLevel2)}\nenter, чтобы вернуться")
            if (Scanner(System.`in`).nextLine().isEmpty()) level = "notes"
        }
    }
    println("Программа завершила работу. До свидания!")
}

fun getInput(): Int {
    val input = Scanner(System.`in`)
    return if (input.hasNextInt()) input.nextInt() else -1
}





