import java.util.Scanner

var archieves = mutableListOf<Archieve>()
var scanner = Scanner(System.`in`)

fun createArch() {
    println("Введите название архива")
    var newArchName = scanner.nextLine()
    archieves.add(Archieve(newArchName))
}

fun <T>startMain(
    text: String,
    list: List<T>,
    thisArch: Archieve?,
    note: Note?
) {
    if(note != null) {
        println("${note.printNote()}\n")
        println("Введите от 0 или 1 для возврата к списку")
    } else {
        println(text)
        println("0. Создать $text")

        list.forEachIndexed { i, element -> println("${i+1} $element") }
        println("${list.size + 1}. Выход")
        println("Выберите действие, введя номер пункта:")
    }
    var inputOk = false
    while (!inputOk) {
        val userInput : Int? = scanner.nextLine().toIntOrNull()

        if(userInput != null) {
            if(userInput <= (list.size+1)) {
                inputOk = when(userInput) {
                    0 -> {
                        if (note != null) {
                            true
                        } else {
                            create(text, list, thisArch)
                        }
                    }
                    list.size + 1 -> true
                    else -> {
                        chooseItem("Список заметок",list, userInput, thisArch)
                    }
                }
            }
        }
    }
}

fun <T> create(
    text: String,
    list: List<T>,
    thisArch: Archieve?
):Boolean {
    if(thisArch != null) {
        thisArch.addNotes()
        printNotesLists(text,list,thisArch)
    } else {
        createArch()
        printArchieveLists(text,list)
    }
    return true
}

fun <T> chooseItem(
    text: String,
    list: List<T>,
    userInt: Int,
    thisArch: Archieve?
        ): Boolean {
    if(thisArch != null) {
        printNotes(list[userInt - 1] as Note, mutableListOf<Note>())
        printNotesLists(text, list, thisArch)
    } else {
        val thisArchs : Archieve = list[userInt - 1] as Archieve
        printNotesLists(text,thisArchs.printNotes(),thisArchs)
        printArchieveLists("Список архивов:", list)
    }
    return true
}

