import java.util.Scanner

object UserScreen {

    private val archives: MutableList<Archive> = mutableListOf()
    private val sc = Scanner(System.`in`)

    fun showScreen(state: State) {
        when (state) {
            is State.ArchiveListView -> {
                printItems("Список архивов\n0. Создать архив", archives)
                val userInput = inputCheck(archives)
                render(
                    userInput, archives,
                    { showScreen(State.ArchiveCreationView) },
                    { showScreen(State.ArchiveView(archives[userInput - 1])) },
                    { exit() }
                )
            }

            is State.ArchiveView -> {
                printItems("Список заметок в архиве ${state.item.name}\n0. Создать заметку", state.item.notes)
                val userInput = inputCheck(state.item.notes)
                render(
                    userInput, state.item.notes,
                    { showScreen(State.NoteCreationView(state.item)) },
                    { showScreen(State.NoteView(state.item.notes[userInput - 1])) },
                    { showScreen(State.ArchiveListView) }
                )
            }

            is State.ArchiveCreationView -> {
                println("Создаем крутой архив!\nВведите название архива:")
                val userInput = sc.nextLine()
                archives.add(Archive(userInput))
                println("Окей, добавили архив $userInput")
                showScreen(State.ArchiveListView)
            }

            is State.NoteView -> {
                println("Просмотр заметки:\n\n${state.item.text}\nДля возврата введите 0")
                while (sc.hasNext()) {
                    if (sc.nextLine() == "0") break
                }
                showScreen(State.ArchiveView(state.item.archive))
            }

            is State.NoteCreationView -> {
                println("Создаем супер заметку!\nВведите текст заметки: ")
                val userInput = sc.nextLine()
                state.item.notes.add(Note(userInput, state.item))
                println("Окей, добавили заметку!")
                showScreen(State.ArchiveView(state.item))
            }
        }
    }

    private fun render(
        userInput: Int,
        list: List<Printable>,
        createItem: () -> Unit,
        showItem: (Int) -> Unit,
        exit: () -> Unit,
    ) {
        when (userInput) {
            0 -> createItem()
            in 1..list.size -> showItem(userInput - 1)
            list.size + 1 -> exit()
        }
    }

    private fun printItems(tittle: String, list: List<Printable>) {
        println(tittle)
        list.forEachIndexed { index, it ->
            println("${index + 1}. ${it.getItem().take(10)}...")
        }
        println("${list.size + 1}. Выход")
    }

    private fun inputCheck(list: List<Printable>): Int {
        while (true) {
            try {
                val input = sc.nextLine().toInt()
                if (input < 0 || input > list.size + 1) {
                    println("Упс! Кажется, произошел промах по цифрам... Давайте еще попробуем")
                } else {
                    return input
                }
            } catch (e: Exception) {
                println("Ой! Ошибочка! Попробуйте ввести цифры от 0 до ${list.size + 1}:")
            }
        }
    }

    private fun exit() {
        println("Урадавайура!")
        return
    }
}