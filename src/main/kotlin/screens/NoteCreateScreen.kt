package screens

import InOutUtils
import data.StorageOfNotes
import data.model.Note
import kotlin.properties.Delegates

class NoteCreateScreen(private val storage: StorageOfNotes): BaseScreen() {
    override var tittleScreen: String = "Создание заметки:"
    override val menuList: MutableList<String> = mutableListOf()
    private var targetIdArchive by Delegates.notNull<Int>()

    private var tittleNote: String? = null
    private var textNote: String? = null

    fun runScreen(idArchive: Int) {
        targetIdArchive = idArchive
        initData()
        showMenu()
        waitUserCommand()
    }

    private fun initData() {
        menuList.add("Указать заголовок заметки")
        menuList.add("Указать содержание заметки")
        menuList.add("Назад")
    }

    override fun showMenu() {
        println("======")
        println(tittleScreen)
        updateMenu()
    }

    private fun waitUserCommand() {
        while (true) {
            val command = InOutUtils().readCommand(menuList.size - 1)
            when (command) {
                0 -> {
                    println("Введите заголовок заметки:")
                    tittleNote = InOutUtils().readString()
                    updateMenu()
                }

                1 -> {
                    println("Введите содержание заметки:")
                    textNote = InOutUtils().readString()
                    updateMenu()
                }

                else -> {
                    if (tittleNote.isNullOrBlank() || textNote.isNullOrBlank()) {
                        println("Заголовок или текс заметки не может быть пустым, заметка не сохранена")
                    } else {
                        storage
                            .getArchive(targetIdArchive)
                            .noteList
                            .add(
                                Note(
                                    tittle = tittleNote!!,
                                    textNote = textNote!!
                                )
                            )
                    }
                    endPrintScreen()
                    ArchiveScreen(storage).runScreen(targetIdArchive)
                    break
                }
            }
        }
    }

    private fun updateMenu() {
        println(
            "+                     + \n" +
                    "Заголовок: $tittleNote \n" +
                    "Содержимое: $textNote \n" +
                    "+                     +"
        )
        menuList.forEachIndexed { index, command ->
            println("$index. $command")
        }
        println("------")
        print("Введите пункт меню: ")
    }
}
