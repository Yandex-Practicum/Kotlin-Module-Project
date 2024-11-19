package com.lesa

import com.lesa.model.Archive
import com.lesa.model.Note
import java.util.*

class MenuManager {
    private val archives = mutableListOf<Archive>()
    private val screenStack: ArrayDeque<Screen> = ArrayDeque()
    private val inputManager = InputManager(this) // Создаем экземпляр InputManager

    fun run() {
        greeting()
        navigateTo(Screen.MainScreen)
    }

    private fun greeting() {
        println(WELCOME)
    }

    private fun showScreen(screen: Screen) = when (screen) {
        Screen.MainScreen -> showMainScreen()
        is Screen.ArchiveScreen -> showNoteMenu(screen.archive)
        is Screen.NoteScreen -> showNoteDetails(screen.note)
        Screen.CreateArchive -> createArchive()
        is Screen.CreateNote -> createNote(archive = screen.archive)
    }

    fun navigateTo(screen: Screen) {
        screenStack.addLast(screen)
        showScreen(screen)
    }

    fun navigateBack() {
        if (screenStack.isNotEmpty()) {
            screenStack.removeLast()
        }
        if (screenStack.isEmpty()) {
            println(PROGRAM_IS_COMPLETED)
        } else {
            showScreen(screen = screenStack.last)
        }
    }

    private fun showMainScreen() {
        val commands: MutableList<Command> = mutableListOf()
        commands.add(Command.OpenScreen(Screen.CreateArchive))
        commands.addAll(
            archives.map { Command.OpenScreen(Screen.ArchiveScreen(archive = it)) }
        )
        commands.add(Command.Back(isFirstScreen = screenStack.size == 1))

        showCommands(commands = commands)
    }

    private fun showNoteMenu(archive: Archive) {
        val commands: MutableList<Command> = mutableListOf()
        commands.add(Command.OpenScreen(Screen.CreateNote(archive = archive)))
        commands.addAll(
            archive.notes.map { Command.OpenScreen(Screen.NoteScreen(note = it)) }
        )
        commands.add(Command.Back(isFirstScreen = screenStack.size == 1))

        showCommands(commands = commands)
    }

    private fun showNoteDetails(note: Note) {
        println(String.format(NOTES_NAME, note.title))
        println(String.format(NOTES_TEXT, note.text))
        val commands: List<Command> = listOf(Command.Back(isFirstScreen = screenStack.size == 1))
        showCommands(commands = commands)
    }

    private fun showCommands(commands: List<Command>) {
        commands.forEachIndexed { index, command ->
            println("$index - ${command.name}") // Исправлено для правильного отображения
        }

        val inputIndex = inputManager.readIntInput()
        if (inputIndex < 0 || inputIndex >= commands.size) {
            println(WRONG_INT)
            showCommands(commands) // Повторяем запрос ввода команды
            return
        }

        when (val command = commands[inputIndex]) {
            is Command.Back -> inputManager.navigateBack()
            is Command.OpenScreen -> inputManager.navigateTo(screen = command.screen)
        }
    }

    private fun createArchive() {
        while (true) {
            print(WRITE_ARCHIVES_NAME)
            val title = readln().trim()
            if (title.isNotEmpty()) {
                archives.add(Archive(title = title))
                println(String.format(ARCHIVE_CREATED, title))
                inputManager.navigateBack()
                break // выход из цикла после успешного создания архива
            } else {
                println(WRONG_ARCHIVE_NAME)
            }
        }
    }


//    private fun createNote(archive: Archive) {
//        while (true) {
//            print(WRITE_NOTES_NAME)
//            val title = readln().trim()
//            if (title.isEmpty()) {
//                println(NOTES_NAME_CANT_BE_EMPTY)
//                continue // повторить ввод
//            }
//
//            print(WRITE_NOTES_TEXT)
//            val text = readln().trim()
//            if (text.isEmpty()) {
//                println(NOTES_TEXT_CANT_BE_EMPTY)
//                continue // повторить ввод
//            }
//
//            archive.notes.add(Note(title, text))
//            println(String.format(NOTE_CREATED, title))
//            navigateBack()
//            break // выход из цикла после успешного создания заметки
//        }
//    }

    private fun createNote(archive: Archive) {
        // Ввод названия заметки
        var title: String
        while (true) {
            print(WRITE_NOTES_NAME)
            title = readln().trim()
            if (title.isEmpty()) {
                println(NOTES_NAME_CANT_BE_EMPTY)
                continue // повторить ввод названия заметки
            }
            break // выход из цикла, если название не пустое
        }

        // Ввод текста заметки
        var text: String
        while (true) {
            print(WRITE_NOTES_TEXT)
            text = readln().trim()
            if (text.isEmpty()) {
                println(NOTES_TEXT_CANT_BE_EMPTY)
                continue // повторить ввод текста заметки
            }
            break // выход из цикла, если текст не пустой
        }

        // Добавляем заметку в архив и выводим сообщение
        archive.notes.add(Note(title, text))
        println(String.format(NOTE_CREATED, title))
        navigateBack() // Возврат в предыдущее меню
    }
    private fun readIntInput(): Int {
        print(WRITE_NUMBER)
        val input = readln().toIntOrNull()
        return if (input != null) input else {
            println(WRONG_INT_INPUT)
            readIntInput()
        }
    }

    sealed class Screen {
        data object MainScreen : Screen()
        data class ArchiveScreen(val archive: Archive) : Screen()
        data class NoteScreen(val note: Note) : Screen()
        data object CreateArchive : Screen()
        data class CreateNote(val archive: Archive) : Screen()

        val name: String
            get() = when(this) {
                MainScreen -> MAIN_SCREEN
                is ArchiveScreen -> archive.title
                is NoteScreen -> note.title
                CreateArchive -> CREATE_ARCHIVE
                is CreateNote -> String.format(CREATE_NOTE_IN_ARCHIVE, archive.title)
            }
    }

    sealed class Command {
        data class OpenScreen(val screen: Screen) : Command()
        data class Back(val isFirstScreen: Boolean) : Command()

        val name: String
            get() = when(this) {
                is OpenScreen -> screen.name
                is Back -> if (isFirstScreen) EXIT else BACK
            }
    }


}

