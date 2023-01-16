import Interface.State
import models.Archive
import models.Note
import java.util.Scanner

object Screen : ScreenHandler() {

    private val archives: MutableList<Archive> = mutableListOf()
    private val sc = Scanner(System.`in`)

    fun showScreen(state: State) {
        when (state) {
            is State.ArchiveListView -> {
                printItems("Список архивов\n0. Создать архив", archives)
                val userInput = inputCheck(archives)
                navigate(userInput,
                    archives,
                    { showScreen(State.ArchiveCreationView) },
                    { showScreen(State.ArchiveView(archives[userInput - 1])) },
                    { exit() })
            }

            is State.ArchiveView -> {
                printItems("Список заметок в архиве ${state.item.name}\n0. Создать заметку", state.item.notes)
                val userInput = inputCheck(state.item.notes)
                navigate(userInput,
                    state.item.notes,
                    { showScreen(State.NoteCreationView(state.item)) },
                    { showScreen(State.NoteView(state.item.notes[userInput - 1])) },
                    { showScreen(State.ArchiveListView) })
            }

            is State.ArchiveCreationView -> {
                println("Создаем архив...\nВведите название архива:")
                val userInput = sc.nextLine()
                archives.add(Archive(userInput))
                println("Архив $userInput добавлен")
                showScreen(State.ArchiveListView)
            }

            is State.NoteView -> {
                println("Просмотр заметки:\n\n${state.item.text}\nДля возврата введите 0")
                noteExit()
                showScreen(State.ArchiveView(state.item.archive))
            }

            is State.NoteCreationView -> {
                println("Создаем заметку...\nВведите текст заметки: ")
                val userInput = sc.nextLine()
                state.item.notes.add(Note(userInput, state.item))
                println("Заметка $userInput ддобавлена")
                showScreen(State.ArchiveView(state.item))
            }
        }
    }

    private fun navigate(
        userInput: Int,
        list: List<Any>,
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
}