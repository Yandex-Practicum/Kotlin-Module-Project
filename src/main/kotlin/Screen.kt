import java.util.Scanner

class Screen : ScreenHandler() {

    private val archieves: MutableList<Archieve> = mutableListOf()
    var currentArchieve : Int? = null
    var currentNote : Int? = null

    fun showScreen (screen: Screens) {

        when (screen) {
            Screens.ARCHIEVE -> {
                printMenu("Доступные архивы: \n0. Создать архив", archieves)
                val input = inputCheck(archieves, screen)
                navigation(input, archieves.size+1)
            }

            Screens.NOTES -> {
               val parent = Screens.ARCHIEVE
                printMenu("Заметки в архиве: \n0. Создать заметку", archieves[currentArchieve!!-1].notes)
                val input = inputCheck(archieves[currentArchieve!!-1].notes, screen)
                navigation(input, archieves[currentArchieve!!-1].notes.size+1, parent)
            }

            Screens.CREATE_ARCHIEVE -> {
                println("Введите название архива:")
                val userInput = Scanner(System.`in`).nextLine()
                archieves.add(Archieve(userInput))
                println("Добавлен архив $userInput")
                showScreen(Screens.ARCHIEVE)
            }

            Screens.CREATE_NOTE -> {
                println("Введите название заметки:")
                val noteName = Scanner(System.`in`).nextLine()
                println("Введите текст заметки:")
                val noteText = Scanner(System.`in`).nextLine()
                archieves[currentArchieve!!-1].notes.add(Note(noteName, noteText))
                println("Заметка $noteName добавлена в архив.")
                showScreen(Screens.NOTES)
            }

            Screens.SHOW_NOTE -> openNote(screen)
        }
    }

    private fun openNote(screen: Screens) {
        val noteName = archieves[currentArchieve!!-1].notes[currentNote!!-1].name
        val noteText = archieves[currentArchieve!!-1].notes[currentNote!!-1].text
        println("Название: $noteName")
        println("Текст: $noteText")
        inputCheck(currentScreen = screen)
        showScreen(Screens.NOTES)
    }

    private fun navigation (input: Int, archieveSize: Int, parent: Screens? = null) {
        if (parent == null) {
            if (input == archieveSize) {
                exitProgram()
            } else if (input == 0) {
                showScreen(Screens.CREATE_ARCHIEVE)
            } else {
                currentArchieve = input
                showScreen(Screens.NOTES)
            }
        } else {
            if (input == archieveSize) {
                showScreen(parent)
            } else if (input == 0){
                showScreen(Screens.CREATE_NOTE)
            } else {
                currentNote = input
                showScreen(Screens.SHOW_NOTE)
            }
        }
    }
}