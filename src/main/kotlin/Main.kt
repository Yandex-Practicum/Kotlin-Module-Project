/*

Я хотел сделать класс Main, потому что потом не могу запустить этот класс для дебага,
знаю как это делать через градл, но никак не могу сделать это через идею.

Может вы подскажете?
 */


// Тут я решил не париться со сложной логикой и просто добавить в начало меню архивов нулевой элемент
// Считаю так дешевле и для моих трудозатрат и для самой программы(ну там место в куче, рам и подобное).
val archives: MutableList<Archives> = mutableListOf(Archives(name = "Создать архив", mutableListOf()))

// Просто крашу вывод
val RED = "\u001b[31m"
val RESET = "\u001b[0m"

fun main(args: Array<String>) {
    println("Приветствую в приложении архиватор заметок 3000\n") // Первый экран

    runArchives()

    println("Досвидания")
}

fun runArchives(){
    while (true) {
        println("Список архивов: \n")
        val listOfIndexesArchives: MutableList<Int> = Menu(archives).showMenu()
        when(val getAnswer = PersonInput().inputAnswer()) {
            0 -> createArchive()
            // Мой супер хинт =)
            // По заданию Выход должен быть самым последними, таковым он и является =)
            listOfIndexesArchives.lastIndex + 1 -> break
            in listOfIndexesArchives -> runNotes(archives[getAnswer], getAnswer)
            else -> println(RED + "Вы выбрали несуществующий элемент" + RESET)
        }
    }
}


fun runNotes(archive: Archives, numberArchive: Int){
    while (true){
        val listOfIndexesNotes: MutableList<Int> = Menu(archive.notes).showMenu()
        when(val getAnswer = PersonInput().inputAnswer()){
            0 -> createNote(numberArchive)
            listOfIndexesNotes.lastIndex + 1 -> break
            in listOfIndexesNotes -> showNote(archive.notes, getAnswer)
            else -> println(RED + "Вы выбрали несуществующий элемент" + RESET)
        }
    }
}

fun createArchive(){
    val nameOfArchive: String = PersonInput().containInput(
        Message(
            "Введите имя архива: ",
            "Имя архива не может быть пустым"
        )
    )
    // Аналогично, при создании архива, сразу нулевым элементом добавляю этот пункт меню.
    // Тут уже немного затратнее эта штука, я понимаю, но даже если сделать миллион архивов,
    // Место в памяти занято будет ничтожно мало.
    // P.S. в таком случае только программа создаёт пустое поле note, не пользователь!
    archives.add(Archives(nameOfArchive, mutableListOf(Notes("Создать новую заметку", ""))))
}

fun createNote(index: Int){
    val pairNote: Pair<String, String> = Pair(
            PersonInput().containInput(
                Message("Введите имя заметки: ", "Имя заметки не может пустым")),
            PersonInput().containInput(
                Message("Введите содержание:\n", "Содержание заметки не может быть пустым")))
    archives[index].notes.add(Notes(pairNote.first, pairNote.second))
}

fun showNote(notes: List<Notes>, getAnswer: Int) {
    println("Вывод заметки \"${notes[getAnswer].name}\":")
    println(notes[getAnswer].note + "\n")
}