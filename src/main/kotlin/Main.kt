fun main() {

    moveOnMenu()
}

var arcives = mutableListOf<Archive>()
var note = mutableListOf<Note>()
val textArchiveForMenu = listOf("архивов", "архив")
val textNoteForMenu = listOf("заметок", "заметку")
val textNoteEditMenu = listOf("заметке")

abstract class Storage (val name : String) {

}

class Note (name : String, val id: String, var value: String) : Storage(name) {
}

class Archive (name : String) : Storage(name) {

}

fun moveOnMenu () {
    while (true) {
        val a = Menu()
        val b = a.inputUser(arcives, textArchiveForMenu)
        if (b != 0 && b <= arcives.size) {
            while (true) {
                val menuOfChoosenArcives = mutableListOf<Note>()
                for (i in note) {
                    if (i.id == arcives[b - 1].name) {
                        menuOfChoosenArcives.add(i)
                    }
                }
                val c = a.inputUser(menuOfChoosenArcives, textNoteForMenu)
                if (c != 0 && c <= menuOfChoosenArcives.size) {
                    while (true) {
                        println("Заметка ${menuOfChoosenArcives[c - 1].name}")
                        val d = a.inputUser(menuOfChoosenArcives, textNoteEditMenu)
                        if (d == 1) {
                            for (item in note) {
                                if (item == menuOfChoosenArcives[c - 1]) {
                                    a.editNote(item)
                                }
                            }
                        }
                        if (d == 0) {
                            println("Заметка ${menuOfChoosenArcives[c - 1].name} содержит текст: ${menuOfChoosenArcives[c - 1].value}")
                        }
                        if (d == 2) {
                            break
                        }
                    }
                }
                else if (c == 0) {
                    a.addNote(arcives[b-1].name)
                }
                else {
                    break
                }
            }
        }
        else if (b == 0) {
            a.addArchive()
        }
        else {
            println("Все хорошего!")
            break
        }
    }
}
