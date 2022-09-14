import java.sql.DriverManager.println
import java.util.Scanner

val archiv = mutableListOf<Arhiv>()
val scanner = Scanner(System.`in`)

fun <T>startMain(
    text: String,
    list: List<T>,
    thisArch: Arhiv?,
    note: Note?
) {
    if(note != null) {

        note.printNote()
        println("Введите  0  для возврата к списку")
    } else {
        println(text)
        println("0. Создать $text")

        list.forEachIndexed { i, element -> println("${i+1} $element") }
        println("${list.size + 1}. Выход")
        println("Выберите действие:")
    }
    var enter = false
    while (!enter) {
        val userEnter : Int? = scanner.nextLine().toIntOrNull()
        if(userEnter != null) {
            if(userEnter <= list.size+1) {
                enter = when(userEnter) {
                    0 -> {
                        if (note != null) {
                            true
                        } else {
                            create(text, list, thisArch)
                        }
                    }
                    list.size + 1 -> true
                    else -> {
                        chooseItem("Запись", list, userEnter, thisArch)
                    }
                }
            } else {
                println("Такого действия не существует, введите число от 0 до ${list.size + 1}")
            }
        } else {
            println("Введите число от 0 до ${list.size + 1}")
        }
    }
}

fun <T> create(
    text: String,
    list: List<T>,
    thisArch: Arhiv?
):Boolean {
    if(thisArch != null) {
        thisArch.addNotes()
        PrintNot(text,list,thisArch)
    } else {
        createArch()
        PrintArhiv(text,list)
    }
    return true
}

fun createArch() {
    println("Введите название архива")
    val newArchName = scanner.nextLine()
    archiv.add(Arhiv(newArchName))
}

fun <T> chooseItem(
    text: String,
    list: List<T>,
    userInt: Int,
    thisArch: Arhiv?
): Boolean {
    if(thisArch != null) {
        PrintNotes(list[userInt - 1] as Note, mutableListOf<Note>())
        PrintNot(text, list, thisArch)
    } else {
        val thisArchs : Arhiv = list[userInt - 1] as Arhiv
        PrintNot(text,thisArchs.getNotes(),thisArchs)
        PrintArhiv("Список архивов:", list)
    }
    return true
}
