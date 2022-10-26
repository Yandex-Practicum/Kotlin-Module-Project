package view

import presenter.Presenter

private const val SCREEN_1_TITLE = "Screen #1______основное меню"
 const val ADD_COMMAND = "+"
 const val EXIT_COMMAND = "0"
private const val EXIT = "$EXIT_COMMAND - выход"
private const val ADD_ARCHIVE = "$ADD_COMMAND - создать архив"
private const val CHOOSE_ARCHIVE = "выберите архив по номеру:"
 const val NOT_CORRECT_INPUT = "некорректное значение"
 const val THERE_IS_NO_VALUE = "нет такого значения"


class AllArchiveScreen(presenter: Presenter, function: () -> (Unit)) : Screen(presenter, function) {
    override fun show() {
        println(SCREEN_1_TITLE)
        println(ADD_ARCHIVE)
        println(EXIT)
        println(CHOOSE_ARCHIVE)
        presenter.showAllArchives()
        println("_______________")
        while (true) {
            when (val command = scanner.nextLine()) {
                EXIT_COMMAND -> {
                    onBackPressed.invoke()
                }
                ADD_COMMAND -> {
                    ArchiveCreationScreen(presenter, ::show).show()
                }
                else -> {
                    try {
                        val archive = presenter.chooseArchive(command.toInt())
                        NoteListScreen(archive, presenter, ::show).show()
                    } catch (e: NumberFormatException) {
                        println(NOT_CORRECT_INPUT)
                    } catch (e: IndexOutOfBoundsException) {
                        println(THERE_IS_NO_VALUE)
                    }
                }
            }
        }
    }
}